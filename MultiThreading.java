import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("hello runable");
    }
}

public class MultiThreading {
    static class BlogPost {
        String title;
        String author;
        BlogPostType type;
        int likes;

        public BlogPost(String title, String author, BlogPostType type, int likes) {
            this.title = title;
            this.author = author;
            this.type = type;
            this.likes = likes;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public BlogPostType getType() {
            return type;
        }

        public void setType(BlogPostType type) {
            this.type = type;
        }

        public int getLikes() {
            return likes;
        }

        public void setLikes(int likes) {
            this.likes = likes;
        }
    }

    static enum BlogPostType {
        NEWS,
        REVIEW,
        GUIDE
    }

    static List<BlogPost> posts = new ArrayList(Arrays.asList(new BlogPost("notebook", "you",BlogPostType.NEWS, 10),
            new BlogPost("notebook2", "yo1u",BlogPostType.NEWS, 12)));


    public static void main(String args[]) throws InterruptedException {

        Thread t2 = new Thread(new MyRunnable());
        t2.start();
        System.out.println("");

        Thread thread = new Thread(new LongComputationTask(new BigInteger("2000"), new BigInteger("200000")));
        thread.start();
        thread.interrupt();
        //thread.join(2000);

        Map<BlogPostType, List<BlogPost>> postPerType = posts.stream().collect(Collectors.groupingBy(BlogPost::getType));

    }

    static class LongComputationTask implements Runnable {
        BigInteger base;
        BigInteger power;

        public LongComputationTask(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            System.out.println(pow(base, power));
        }

        public BigInteger pow(BigInteger base, BigInteger power) {
            BigInteger result = BigInteger.ONE;

            try {
                for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
                    result = result.multiply(base);

                    //if (Thread.currentThread().isInterrupted()) {
                    //    return BigInteger.ZERO;
                    //}
                    Thread.sleep(000001);
                }
            } catch (InterruptedException e) {
                System.out.println("Interupted");
            }
            return result;
        }
    }
}
