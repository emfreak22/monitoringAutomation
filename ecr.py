import boto3

class CreateEcrRepository:
    def create_repo(self):
        ecr_client = boto3.client('ecr', region_name='us-east-1')
        repo_name = 'my-cloud-native-app1'
        response = ecr_client.create_repository(repositoryName = repo_name)
        repo_uri = response['repository']['repositoryUri']
        print(repo_uri)

if __name__ == '__main__':
    CreateEcrRepository().create_repo()