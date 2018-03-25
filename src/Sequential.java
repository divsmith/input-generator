import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by parker on 3/24/18.
 */
public class Sequential {

    public static void main(String args[]) throws IOException
    {
        if (args.length < 2)
        {
            usage();
        }

        int total = 0;
        int columns = 0;
        String filename = args[2];

        try
        {
            total = Integer.parseInt(args[0]);
            columns = Integer.parseInt(args[1]);
        }
        catch (NumberFormatException e)
        {
            usage();
        }

        BufferedWriter out = new BufferedWriter(new FileWriter(filename));

        int currentColumn = 1;

        for (int i = 0; i < total; i++)
        {
            out.write(Integer.toString(i));

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
        System.out.println("Usage: java Sequential {total} {columns} {filename}");
        System.exit(0);
    }
}
