# Etapa de build com Maven
FROM maven:3.9.6-eclipse-temurin-21-alpine AS builder

# Definir o diretório de trabalho
WORKDIR /app

# Copiar os arquivos para o contêiner
COPY . .

# Rodar o Maven para compilar a aplicação
RUN mvn clean package -DskipTests

# Etapa para rodar a aplicação com JRE
FROM eclipse-temurin:21-jre-alpine

# Adicionar o usuário 'gustavo' sem privilégios de root
RUN adduser -h /home/gustavo -s /bin/sh -D gustavo

# Definir o diretório de trabalho
WORKDIR /home/gustavo

# Copiar o arquivo JAR compilado da etapa anterior
COPY --from=builder /app/target/*.jar app.jar

# Alterar a propriedade do arquivo JAR para o usuário 'gustavo'
RUN chown gustavo:gustavo app.jar

# Trocar para o usuário 'gustavo'
USER gustavo

# Expor a porta onde o Spring Boot estará rodando
EXPOSE 8080

# Definir o comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
