package murach.data;

import java.io.*;
import java.util.*;

import murach.business.User;

public class UserIO {

    // Ghi một user vào file
    public static boolean add(User user, String filepath) {
        try (PrintWriter out = new PrintWriter(new FileWriter(filepath, true))) {
            out.println(user.getEmail() + "|" + user.getFirstName() + "|" + user.getLastName());
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Tìm một user theo email
    public static User getUser(String email, String filepath) {
        try (BufferedReader in = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = in.readLine()) != null) {
                StringTokenizer t = new StringTokenizer(line, "|");
                if (t.countTokens() < 3)
                    continue;

                String token = t.nextToken();
                if (token.equalsIgnoreCase(email)) {
                    String firstName = t.nextToken();
                    String lastName = t.nextToken();
                    return new User(firstName, lastName, email);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new User("", "", ""); // Không tìm thấy thì trả về user rỗng
    }

    // Đọc toàn bộ danh sách users
    public static ArrayList<User> getUsers(String filepath) {
        ArrayList<User> users = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = in.readLine()) != null) {
                StringTokenizer t = new StringTokenizer(line, "|");
                if (t.countTokens() < 3)
                    continue;

                String email = t.nextToken();
                String firstName = t.nextToken();
                String lastName = t.nextToken();
                User user = new User(firstName, lastName, email);
                users.add(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }
}
