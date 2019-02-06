FROM node as nodetemp
MAINTAINER courterco
WORKDIR /usr/src/app
COPY ./package.json ./
RUN npm install
RUN npm install @angular/cli
RUN npm i -s hammerjs
COPY ./ ./
RUN npm run build

# Stage 2
FROM nginx:1.13.12-alpine
MAINTAINER courterco
COPY --from=nodetemp /usr/src/app/dist/photo-blog-ui/ /usr/share/nginx/html/
COPY nginx.conf /etc/nginx/conf.d/default.conf
