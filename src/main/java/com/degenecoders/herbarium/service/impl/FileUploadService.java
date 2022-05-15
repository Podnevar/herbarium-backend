package com.degenecoders.herbarium.service.impl;

import com.degenecoders.herbarium.client.PlantidServiceClient;
import com.degenecoders.herbarium.model.PlantidRequest;
import com.degenecoders.herbarium.model.PlantidResponse;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class FileUploadService {

    @Inject
    private AmazonS3StorageServiceImpl amazonStorageService;

    @Inject
    @RestClient
    private PlantidServiceClient plantidServiceClient;

    public void uploadFile(MultipartFormDataInput input) {
        List<String> base64Images = new ArrayList();
        List<byte[]> images = new ArrayList<>();
        List<String> modifiers = new ArrayList<>();
        List<String> plantDetails = new ArrayList<>();
        List<String> languages = new ArrayList<>();
        Map<String, List<InputPart>> uploadForm = input.getFormDataMap();
        List<String> fileNames = new ArrayList<>();
        List<InputPart> inputParts = uploadForm.get("file");

        // Configuration
        String fileName = null;
        modifiers.add("similar_images");
        plantDetails.add("common_names");
        plantDetails.add("url");
        plantDetails.add("wiki_description");
        plantDetails.add("edible_parts");
        plantDetails.add("gbif_id");
        plantDetails.add("propagation_methods");
        plantDetails.add("Taxonomy");
        languages.add("sl");
        languages.add("en");

        for (InputPart inputPart : inputParts) {
            try {
                MultivaluedMap<String, String> header =
                        inputPart.getHeaders();
                fileName = getFileName(header);
                fileNames.add(fileName);
                InputStream inputStream = inputPart.getBody(InputStream.class, null);
                byte[] bytes = IOUtils.toByteArray(inputStream);
                images.add(bytes);
                base64Images.add(Base64.encodeBase64String(bytes));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        PlantidRequest plantidRequest = PlantidRequest.builder()
                .images(base64Images)
                .modifiers(modifiers)
                .plantDetails(plantDetails)
                .plantLanguages(languages)
                .build();

        Response response = plantidServiceClient.identify("vK8N7x3e2HMmsmdgOkQ7kQ3corlxLIfjFdfxJWeSGzhuRLk9Fz", plantidRequest);
        PlantidResponse plantidResponse = response.readEntity(PlantidResponse.class);

        if (response.getStatus() == 200 && plantidResponse.getSuggestions().get(0) != null) {
            amazonStorageService.store(fileName, images.get(0));
        }
    }

    private String getFileName(MultivaluedMap<String, String> header) {
        String[] contentDisposition = header.
                getFirst("Content-Disposition").split(";");
        for (String filename : contentDisposition) {
            if ((filename.trim().startsWith("filename"))) {
                String[] name = filename.split("=");
                String finalFileName = name[1].trim().replaceAll("\"", "");
                return finalFileName;
            }
        }

        return "";
    }
}
