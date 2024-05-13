import java.util.Random;

public class Demo
{
    public static void main(String[] args)
    {
        MyHashSet<Integer> and = new MyHashSet<>();
        Random random = new Random();
        for (int i = 0; i < 10000; i++)
        {
            and.add(random.nextInt(1,101));
        }
    }
}