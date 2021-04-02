import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        StringBuilder sb = new StringBuilder();
        while ((input = br.readLine()) != null) {
            String[] split = input.split("[ \t]");
            for (String word : split) {
                switch (word) {
                    case "<br>" -> {
                        bw.write(sb.toString() + "\n");
                        sb = new StringBuilder();
                    }
                    case "<hr>" -> {
                        if (!sb.isEmpty()) {
                            bw.write(sb.toString() + "\n");
                        }
                        bw.write("--------------------------------------------------------------------------------\n");
                        sb = new StringBuilder();
                    }
                    default -> {
                        if (!word.isBlank()) {
                            if (sb.toString().length() == 0) {
                                sb.append(word);
                            } else if (sb.toString().length() + word.length() + 1 <= 80) {
                                sb.append(" ").append(word);
                            } else {
                                bw.write(sb.toString() + "\n");
                                sb = new StringBuilder();
                                sb.append(word);
                            }
                        }
                    }
                }
            }
        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}