package com.degenecoders.herbarium.service;

public interface StorageService {
    /**
     * Store image to cloud storage.
     *
     * @param fileName name of the file
     * @param bytes image in bytes
     */
    public void store(String fileName, byte[] bytes);

    /**
     * Retrieve image from cloud storage
     *
     * @param fileName name of the file
     * @return image encoded into Base64
     */
    public String retrieve(String fileName);
}
