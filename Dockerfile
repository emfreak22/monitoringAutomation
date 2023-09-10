# Get python image from dockerhub
FROM python:3.11-slim-buster

# Setting work directory as /app in docker
WORKDIR /app

# copying requirements file to execute it later
COPY requirements.txt .

# Running requirements file with no cache on
RUN pip install -r requirements.txt

# Copying what ever is in current directory to flask current directory
COPY . .

# Running on host 0.0.0.0
ENV FLASK RUN HOST=0.0.0.0

# Exposing the Port
EXPOSE 5000

# Run flask app whichever is in current directory
CMD ["flask", "run"]

# Invoke it using docker build -t My-app:Latest .
# It will build an image using the conents in the . directory and name it as My-app and version will be latest

