# sandbox-scala-play

start MySQL container (port: 53306)

```console
$ docker compose up -d
$ mysql -h 127.0.0.1 -P 53306 -u root -ppw play
```

start server (port: 59000)

```console
$ sbt run
```
