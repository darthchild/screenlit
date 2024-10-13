# Stage 1 : Building the React App
FROM node:20-alpine as builder

WORKDIR /app

COPY package.json .

RUN npm install

COPY . .

RUN npm run build

# Stage 2 : Serving the App
FROM nginx:stable-alpine

COPY nginx.conf /etc/nginx/conf.d/default.conf
 
COPY --from=builder /app/build /usr/share/nginx/html

EXPOSE 80

ENTRYPOINT [ "nginx", "-g", "daemon off;" ]