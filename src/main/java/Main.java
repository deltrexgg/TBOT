import com.veinhorn.forismatic.api.Forismatic;
import com.veinhorn.forismatic.api.Language;
import com.veinhorn.forismatic.api.Quote;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {
    public static WebDriver driver = null;
    public static String stock;
    public static String advice;
    public static String quoteText;

    public static void main(String args[]) throws Exception {
        for (int i = 1; i > 0; i++) {

            for (int j = 0; j < 25; j++) {


                String[] location = {"[\"AAPL\",\"NASDAQ\"],\"Apple Inc\",0,\"USD\",[",
                        "[\"MSFT\",\"NASDAQ\"],\"Microsoft Corp\",0,\"USD\",[",
                        "[\"KO\",\"NYSE\"],\"Coca-Cola Co\",0,\"USD\",[",
                        "[\"TSLA\",\"NASDAQ\"],\"Tesla Inc\",0,\"USD\",[",
                        "[\"NFLX\",\"NASDAQ\"],\"Netflix Inc\",0,\"USD\",[",
                        "[\"NDAQ\",\"NASDAQ\"],\"Nasdaq Inc\",0,\"USD\",[",
                        "[\"SONY\",\"NYSE\"],\"Sony Group Corp\",6,\"USD\",[",
                        "[\"DIS\",\"NYSE\"],\"Walt Disney Co\",0,\"USD\",[",
                        "[\"PEP\",\"NASDAQ\"],\"PepsiCo, Inc.\",0,\"USD\",[",
                        "[\"AMZN\",\"NASDAQ\"],\"Amazon.com, Inc.\",0,\"USD\",[",
                        "[\"MCD\",\"NYSE\"],\"McDonald's Corp\",0,\"USD\",[",
                        "[\"SBUX\",\"NASDAQ\"],\"Starbucks Corp\",0,\"USD\",[",
                        "[\"ADDDF\",\"OTCMKTS\"],\"adidas AG\",0,\"USD\",[",
                        "[\"NKE\",\"NYSE\"],\"Nike Inc\",0,\"USD\",[",
                        "[\"SPOT\",\"NYSE\"],\"Spotify Technology SA\",0,\"USD\",[",
                        "[\"META\",\"NASDAQ\"],\"Meta Platforms Inc\",0,\"USD\",[",
                        "[\"GOOGL\",\"NASDAQ\"],\"Alphabet Inc Class A\",0,\"USD\",[",
                        "[\"HMC\",\"NYSE\"],\"Honda Motor Co Ltd\",6,\"USD\",[",
                        "[\"NSANY\",\"OTCMKTS\"],\"Nissan Motor Co Ltd\",6,\"USD\",[",
                        "[\"NVDA\",\"NASDAQ\"],\"NVIDIA Corporation\",0,\"USD\",[",
                        "[\"BABA\",\"NYSE\"],\"Alibaba Group Holding Ltd - ADR\",6,\"USD\",[",
                        "[\"MU\",\"NASDAQ\"],\"Micron Technology Inc\",0,\"USD\",[",
                        "[\"BLK\",\"NYSE\"],\"BlackRock Inc\",0,\"USD\",[",
                        "[\"V\",\"NYSE\"],\"Visa Inc\",0,\"USD\",[",
                        "[\"GME\",\"NYSE\"],\"GameStop Corp.\",0,\"USD\",["};

                String[] weburl =
                        {"https://www.google.com/finance/quote/AAPL:NASDAQ?hl=en",
                                "https://www.google.com/finance/quote/MSFT:NASDAQ?hl=en",
                                "https://www.google.com/finance/quote/KO:NYSE?hl=e",
                                "https://www.google.com/finance/quote/TSLA:NASDAQ?hl=en",
                                "https://www.google.com/finance/quote/NFLX:NASDAQ?hl=en",
                                "https://www.google.com/finance/quote/NDAQ:NASDAQ?hl=en",
                                "https://www.google.com/finance/quote/SONY:NYSE?hl=en",
                                "https://www.google.com/finance/quote/DIS:NYSE?hl=en",
                                "https://www.google.com/finance/quote/PEP:NASDAQ?hl=en",
                                "https://www.google.com/finance/quote/AMZN:NASDAQ?hl=en",
                                "https://www.google.com/finance/quote/MCD:NYSE?hl=en",
                                "https://www.google.com/finance/quote/SBUX:NASDAQ?hl=en",
                                "https://www.google.com/finance/quote/ADDDF:OTCMKTS?hl=en",
                                "https://www.google.com/finance/quote/NKE:NYSE?hl=en",
                                "https://www.google.com/finance/quote/SPOT:NYSE?hl=en",
                                "https://www.google.com/finance/quote/META:NASDAQ?hl=en&window=5Y",
                                "https://www.google.com/finance/quote/GOOGL:NASDAQ?hl=en",
                                "https://www.google.com/finance/quote/HMC:NYSE?hl=en",
                                "https://www.google.com/finance/quote/NSANY:OTCMKTS?hl=en",
                                "https://www.google.com/finance/quote/NVDA:NASDAQ?hl=en",
                                "https://www.google.com/finance/quote/BABA:NYSE?hl=en",
                                "https://www.google.com/finance/quote/MU:NASDAQ?hl=en",
                                "https://www.google.com/finance/quote/BLK:NYSE?hl=en",
                                "https://www.google.com/finance/quote/V:NYSE?hl=en",
                                "https://www.google.com/finance/quote/GME:NYSE?hl=en"};

                String[] copname = {"#Apple", "#Microsoft", "#Coco-Cola", "#Tesla", "#Netflix", "#Nasdaq",
                        "#Sony", "#Disney", "#Pepsi Co", "#Amazon", "#McDonald's", "#Starbucks Corp", "#Adidas AG",
                        "#Nike Inc", "#Spotify", "#Meta", "#Alphabet Inc", "#Honda Motor Co Ltd", "#Nissan Motor Co Ltd",
                        "#NVIDIA Corporation", "#Alibaba Group Holding Ltd - ADR", "#Micron Technology Inc", "#BlackRock Inc",
                        "#Visa Inc", "#GameStop Corp"};


                URL url = new URL(weburl[j]);
                URLConnection urlConn = url.openConnection();
                InputStreamReader inStream = new InputStreamReader(urlConn.getInputStream());
                BufferedReader buff = new BufferedReader(inStream);
                String line = buff.readLine();
                int positionlen = location[j].length();
                while (line != null) {
                    if (line.contains(location[j])) {
                        int num;
                        num = line.indexOf(location[j]);
                        int len = line.length();
                        String newline = line.substring(num + positionlen, len);
                        int coma = newline.indexOf(",");
                        stock = copname[j] + " share price - $" + newline.substring(0, coma);
                        System.out.println(stock);

                        selenium call = new selenium();
                        call.start();

                        System.out.println("--------------");


                    }
                    line = buff.readLine();
                }
               Thread.sleep(1200000);
               System.setProperty("webdriver.edge.driver","C:\\msedgedriver.exe");
                driver = new EdgeDriver();
                driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

                driver.navigate().to("https://phrasegenerator.com/finance");

                Thread.sleep(8000);

                advice = driver.findElement(By.cssSelector("body > div > div.right-area > div > div.content-area > div.phrase-panel > div > div.phrase-inner > div")).getText();
                /*
                Random rand1 = new Random();
                int random1 = rand1.nextInt(1, 4);
                String[] financehashtag = {"#finance","#market","#news","#business"};
                text = text + "       "+financehashtag[random1];

                 */

                System.out.println(advice);

                selenium1 call1 = new selenium1();
                call1.start();

                System.out.println("--------------");

                driver.close();

                Thread.sleep(1200000);

                Quote quote = new Forismatic(Language.ENGLISH).getQuote();
                Forismatic forismatic = new Forismatic();
                forismatic.setLanguage(Language.ENGLISH);
                quoteText = quote.getQuoteText();

                Random rand = new Random();
                int random = rand.nextInt(1, 4);
                String[] motivhashtag = {"#motivation","#inspiration","#success","#life"};
                quoteText = quoteText  + "        "+motivhashtag[random];
                System.out.println(quoteText);

                selenium2 call2 = new selenium2();
                call2.start();


                System.out.println("-------------");
                Thread.sleep(1200000);

            }

                }
            }
        }





