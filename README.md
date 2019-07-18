# bestsecret-api
Project test Java

##The property "file.words.path" in the file application.properties is absolute path, need to be change

After the git clone, run the mvn clean install command.

You can see the tests being run.

Then run "java -jar target/ghostgame-api-0.0.1-SNAPSHOT.jar"  command

If you want to change the port other than 8080 is in the file application.properties property server.port


After executing the commands, import the bestsecret.postman_collection.json file from the doc folder in Postman to test the services.

# FindWord
GET: http://localhost:8080/api/ghostGame/a/a
