@echo off
REM Build and Push Frontend Docker Image to Docker Hub

SET /P DOCKER_USERNAME=Enter your Docker Hub username: 
IF "%DOCKER_USERNAME%"=="" (
    echo Error: Docker Hub username is required
    exit /b 1
)

SET IMAGE_NAME=%DOCKER_USERNAME%/hr-frontend
SET IMAGE_TAG=latest

echo Building Docker image for HR Frontend...
docker build -t %IMAGE_NAME%:%IMAGE_TAG% .

echo Pushing Docker image to Docker Hub...
docker push %IMAGE_NAME%:%IMAGE_TAG%

echo Build and push completed successfully!
echo Image: %IMAGE_NAME%:%IMAGE_TAG%
