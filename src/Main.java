import java.io.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) throws IOException {
        if (args.length < 4)
        {
            usage();
        }

        String filename = args[4];
        int total = 0;
        int min = 0;
        int max = 0;
        int columns = 0;

        try
        {
            total = Integer.parseInt(args[0]);
            min = Integer.parseInt(args[1]);
            max = Integer.parseInt(args[2]);
            columns = Integer.parseInt(args[3]);
        }
        catch (NumberFormatException e)
        {
            usage();
        }

        BufferedWriter out = new BufferedWriter(new FileWriter(filename));

        int currentColumn = 1;

        for (int i = 0; i < total; i++)
        {
            out.write(Integer.toString(ThreadLocalRandom.current().nextInt(min, max + 1)));

            if (currentColumn == columns)
            {
                out.write(new String("\n"));
                currentColumn = 1;
            }
            else
            {
                out.write(new String(" "));
                currentColumn++;
            }
        }

        out.close();
    }

    public static void usage()
    {
        System.out.println("Usage: java input {total} {min} {max} {columns} {file}");
        System.exit(0);
    }
}
