FROM bellsoft/liberica-openjdk-alpine
COPY ./src ./src
RUN mkdir ./out
RUN javac -sourcepath ./src -d out src/Main.java
CMD java -cp ./out Main