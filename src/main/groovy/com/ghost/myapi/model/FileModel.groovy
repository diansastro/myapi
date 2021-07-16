package com.ghost.myapi.model

import org.springframework.util.StringUtils

/**
 * Created by widi (widiytk@gmail.com) on 2021-07-16.
 **/

class FileModel {
    String fileName
    String fileAttribute
    String fileContent

    FileModel(String fileData) {
        if (!StringUtils.isEmpty(fileData)) {
            String[] dataColection = fileData.split(",")
            String[] attributeCollection = dataColection[0].split(";")
            this.fileName = fileAttribute.replace('/', '-') + "-" + System.currentTimeMillis()
            this.fileContent = dataColection[1] // get file
            this.fileAttribute = attributeCollection[0].split(":")[1] // get content type
        }
    }

    Boolean isValid() {
        return fileName != null && fileAttribute != null && fileContent != null
    }

    String getFileName() {
        return fileName
    }


    String getFileAttribute() {
        return fileAttribute
    }

    String getFileContent() {
        return fileContent
    }
}
