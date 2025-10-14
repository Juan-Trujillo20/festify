# syntax=docker/dockerfile:1.7

# Args que pasarás desde el workflow
ARG PROFILE=dev
ARG APP_VERSION=dev

# Runtime estable y multi-arch (Debian/Ubuntu), no Alpine
FROM --platform=$TARGETPLATFORM eclipse-temurin:17-jre-jammy AS runtime

# Metadatos útiles
LABEL org.opencontainers.image.title="Festify" \
      org.opencontainers.image.version="${APP_VERSION}" \
      org.opencontainers.image.description="Festify API" \
      org.opencontainers.image.licenses="MIT"

# Directorio app y usuario no root
WORKDIR /app
RUN useradd -r -u 10001 appuser && chown -R appuser:appuser /app
USER appuser

# Copiamos el jar construido por Maven en CI
# (tu pipeline ya hace `mvn package` y deja el jar en target/)
COPY --chown=appuser:appuser target/*.jar /app/app.jar

# Variables de entorno típicas (Spring)
ENV SPRING_PROFILES_ACTIVE=${PROFILE} \
    APP_VERSION=${APP_VERSION} \
    JAVA_OPTS=""

EXPOSE 8080

# Healthcheck (si tienes actuator; si no, elimina esta línea)
HEALTHCHECK --interval=30s --timeout=3s --start-period=20s --retries=3 \
  CMD sh -c 'wget -qO- http://127.0.0.1:8080/actuator/health || pgrep -f app.jar >/dev/null || exit 1'

ENTRYPOINT ["sh","-c","java $JAVA_OPTS -jar /app/app.jar"]