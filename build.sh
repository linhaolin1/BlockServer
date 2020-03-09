mvn clean install

mkdir -p output output/docker output/jar output/plugins output/js output/sql output/management output/nginx

cp target/blockServer-0.0.1-SNAPSHOT.jar output/jar/
cp -r src/main/resources/docker/ output/docker/
cp demo/plugins/*.jar output/plugins/
cp src/main/resources/sql/*.sql output/sql/
cp src/main/resources/js/*.js output/js/
cp -r src/main/resources/management/ output/management/
cp -r src/main/resources/nginx/ output/nginx/
chmod +x output/jar/blockServer-0.0.1-SNAPSHOT.jar
