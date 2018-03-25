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
        String filename = args[1];

        try
        {
            total = Integer.parseInt(args[0]);
        }
        catch (NumberFormatException e)
        {
            usage();
        }

        BufferedWriter out = new BufferedWriter(new FileWriter(filename));

        out.write(Integer.toString(total));
        out.write(new String("\n"));

        for (int i = 0; i < total - 1; i++)
        {
            out.write(Integer.toString(i));
            out.write(new String(" "));
            out.write(Integer.toString(i + 1));
            out.write(new String("\n"));
        }

        out.close();
    }

    public static void usage()
    {
        System.out.println("Usage: java Sequential {total} {filename}");
        System.exit(0);
    }
}
