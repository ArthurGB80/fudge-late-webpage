FROM nginx:1.25.4

RUN apt-get remove --purge -y \
    apache2* \
    && rm -rf /var/lib/apt/lists/*

RUN apt-get update && apt-get upgrade -y

RUN apt-get update && apt-get install -y --no-install-recommends debsecan

COPY dist/angular_in_container /us4r/share/nginx/html

EXPOSE  80

CMD ["nginx", "-g", "daemon off;"]