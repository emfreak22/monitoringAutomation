pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Checkout code from GitHub
                checkout([$class: 'GitSCM', branches: [[name: 'master']], userRemoteConfigs: [[url: 'https://github.com/emfreak22/monitoringAutomation']]])
            }
        }
        stage('Build') {
            steps {
                // Build your code (if necessary)
            }
        }
        stage('Deploy') {
            steps {
                // Deploy code to your Ubuntu server using SSH
                sshagent(credentials: ['-----BEGIN RSA PRIVATE KEY-----
MIIEowIBAAKCAQEAhnr7DIh/+7pSP1IkPkzXPcpn/+vbTv2hrosrnegG5Vwcernp
C1poxKVzEA6FyEXtY7n3w+4Atq6SXluDRF3d05itpZyx9Pti4KqGfnIelVCgJjar
AjcnomnrSVW27SrGp2B403VcMvBFVbSHQpyBrbJvPSK4NjL0+c4sQZz+jt1aNGLU
lk+9ch3HeRsXtapbDAxEZN7n3MTvhpVwx39N4ouUfNPJ9mKWHksuzAhg66dE3hrE
pS87vBHkXXdDQTmfN9RKojjowIvHtia07sMF54iaXcJHbDDlY02wQBtuVBKcarDt
xbEWDbPljW+gVXsYcysW1zdPUeyRim+kVRghbwIDAQABAoIBACk1uIbfsXB/aULU
Nh0NSQw7YWFQcnUjTg+BwEz0VGCmuGd3Xw3Gl8Ji/P6XpLF5lERyMZXN8lQI7PuT
SYeCyD5WVCgi+3maK3OzbeGDsRGKknkDWaYlJrUjhiGD7bmB2TxjWMNb/HPzoxuf
Za+o7ChBPMtcP10EgoOmhXNZ27wFbaq3YSaWpcxlMnd792DgTLh9wW5yui2GvBGh
K9Ix/SbumtPkUvZ9nFjXw5knOYx3hBV1BnNqaLTBCrHSCFp8YiD0Cwfq4mGeAN4M
LlDOJIvIi7XK+XW3DpGPgLcF5F42gNoVAJ96AuJzN3tOEo0CZ40REXctz7/EyIbQ
PhlTeiECgYEA7cLFgPxVrHYlLPb4fnkuKCL3FXj5Rlxgg+L1of6h8kGSkr6CBQXG
WV4HMFGDoWLqbwJ5eFj6kAFL5pdPRoWX0nN2WsahGuUY644iImlcwXKnPJ7CXj8s
cfEdYIjF14CSEJxXYYh8trIuc54Iu/JJSv2Oqw34ipJ9PhuiE3m/qL8CgYEAkMvz
4Y23eHb0hrdWBapEbDYbfnx8PhvyPLMfJUGbjY9pCAi/bzfO6/4Mo/mpDkOfPgpS
QSNqtEfjExA+7gdndhhhgZ8SIl01kNVDWOD+ii8jyPhqpt6QrZ2uUB4K7+oQ7oMb
A6kZxwYWw0sSboOV4rpzQP2u59vQ3OpZz4Bmg1ECgYEAySi5IWBcvAVZfqmVpKuy
OZMbqbcocDdIEU28tMpTCjwgXreAGe/A2WuMeXz9+VVPM4zMaN4fYCc4qGfsUqZE
xXGa+UKEm9SpOOKQTr0GFUWD6O4JVOPuHpj5WeteN+43poYgCA0KNyiZ1Igoq5ta
F3BffKndVqCKBjoq7n9bgNECgYA5ipN0gxjyKnOqRZlNzwg56JasgVPuarStIpGy
AIyMiP04UCGjVQ5KAj+Lul9QZ9cUlI1zjVuOITNAFCit9wtKhw3YsRpHxbrPv7Bv
1ZnR2EHkT7QydCgSlqL6+7Vk+iOYZUmK/txblzPckCzW9jvOSkIbBbVINrad1BO0
vlX+wQKBgB0vFFmAXkvXDKIfQOWnpgPSl9QJH9OxsUtmdNrI0mE1fwQRwvkHCvI6
o4UkeSG+mw43SuTrECQhG8QlzdQQGzjlC9g4EbpnFFa0e5nJKQfqpItqqCg44V8l
tlqNqCV1fGPnmMZnXEBpypMr5vzAUa9OWXRcsXe97y4llZ8mvgvq
-----END RSA PRIVATE KEY-----']) {
                    sh '''
                        ssh ubuntu@y18.208.226.0 'cd /home/app/serverMonitoring && git pull'
                        # Add any other deployment steps here
                    '''
                }
            }
        }
    }
}
