# App para realizar alguns testes

- Múltiplos Classes com métodos main (ApiApplication, CronJobApplication, WorkerApplication)
- Padrão de projeto strategy com spring boot usando services com nomes
- A ideia é avaliar se pessoas estão aptas a receber uma oferta de aplicativos de musica

### Passo 1

- Executar `mvn clean install` para gerar o jar do projeto
- Executar `docker-compose up -d` para subir os containers

### Passo 2

- Start da aplicação para com uma API que irá cadastrar produzir pessoa produzir mensagens kafka
    - `java -jar ./target/app.jar`
    - `curl --location --request POST 'http://localhost:8080/api/person' \
      --header 'Content-Type: application/json' \
      --data-raw '{
      "name": "bbbbb1",
      "age": 10 }'`

- Start da aplicação para um cronjob que irá ser iniciado via kubernetes
    - `java -cp ./target/app.jar -Dloader.main=com.demo.CronJobApplication org.springframework.boot.loader.PropertiesLauncher`

- Start da aplicação para um worker que irá consumir mensagens kafka
    - `java -cp ./target/app.jar -Dloader.main=com.demo.WorkerApplication org.springframework.boot.loader.PropertiesLauncher`
  




