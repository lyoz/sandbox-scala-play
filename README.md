# sandbox-scala-play

start MySQL container (port: 13306)

```console
$ docker compose up -d
$ mysql -h 127.0.0.1 -P 13306 -u root -ppw lyoz
```

start server (port: 19000)

```console
$ sbt run
```
