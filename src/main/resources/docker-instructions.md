# FIRST RUN INSTRUCTIONS

### MySQL
---

If no MySQL-server is installed on the host machine,
add the ports so that MySQL-server is accesible by MySQLWorkbench at localhost:3306
If no other image runs in docker, the IP given to MySQL will be 172.17.0.2

```bash
sudo docker run -p 3306:3306 --name some-mysql -e MYSQL_ROOT_PASSWORD=root -d mysql:latest
```

### Grafana
---
```bash
sudo docker run -d -p 3000:3000 --name grafana grafana/grafana:6.5.0
```

edit the file /etc/grafana/grafana.ini using:

```bash
sudo docker exec -u root -it grafana vi /etc/grafana/grafana.ini
```

set the following:

```bash
allow_embedding=true
#enable anonymous access
enabled=true
```

1. Configure datasource to 172.17.0.2:3306 or whatever IP was given to MySQL by docker (localhost will not work)
1. Import dashboard JSON
1. If necessary reconfigure the datasource from the panels edit menu
1. Install any plugins, ex:

```bash
sudo docker exec -it grafana grafana-cli plugins install grafana-piechart-panel
```

### SpringBoot app
---

From the projects base directory (the one with pom.xml and Dockerfile) run:

```bash
sudo docker build -t oop/airquality:AirQuality-0.0.1-SNAPSHOT .
```

the folder/projectname is just a convention seen here: https://codefresh.io/docker-tutorial/create-docker-images-for-java/

```bash
sudo docker run -p 8080:8080 oop/airquality:AirQuality-0.0.1-SNAPSHOT -->
```
