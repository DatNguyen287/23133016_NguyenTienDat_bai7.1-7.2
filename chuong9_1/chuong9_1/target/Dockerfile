# Sử dụng official Tomcat image (phiên bản 9.0)
FROM tomcat:9.0

# Xóa file ROOT default của Tomcat
RUN rm -rf /usr/local/tomcat/webapps/ROOT

# Copy file WAR của bạn vào thư mục webapps với tên ROOT.war để nó chạy mặc định trên context root
COPY chuong9_1.war /usr/local/tomcat/webapps/ROOT.war

# Expose port 8080 để truy cập Tomcat
EXPOSE 8080

# Khởi động Tomcat
CMD ["catalina.sh", "run"]
