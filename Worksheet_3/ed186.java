class Point {
   int x, y;

   Point() {
      x = y = 0;
   }
   
   Point(int x0, int y0) {
      x = x0;
      y = y0;
   }

   public String toString() {
      return "(" + x + "," + y + ")";
   }
}

class Rectangle {
    private Point ie;
    private Point sd;

    Rectangle(int x1, int y1, int x2, int y2) {
        ie = new Point(x1, y1);
        sd = new Point(x2, y2);
    }

    Rectangle(Point p1, Point p2) {
        ie = p1;
        sd = p2;
    }

    public int area() {
        int largura = sd.y - ie.y;
        int comprimento = sd.x - ie.x;
        return largura * comprimento;

    }

    public int perimeter() {
        int largura = sd.y - ie.y;
        int comprimento = sd.x - ie.x;
        return 2 * largura + 2 * comprimento;
    }

    public boolean pointInside(Point p) {
        int counter = 0;
        if (p.x >= ie.x && p.x <= sd.x){
            counter += 1;
        }
        if (p.y >= ie.y && p.y <= sd.y){
            counter += 1;
        }

        if (counter == 2) {
            return true;
        } else {
            return false;
        }
    }

    public boolean rectangleInside (Rectangle r) {
        int counter = 0;

        if (r.ie.x >= ie.x && r.ie.x <= sd.x){
            counter += 1;
        }
        if (r.ie.y >= ie.y && r.ie.y <= sd.y){
            counter += 1;
        }
        if (r.sd.x >= ie.x && r.sd.x <= sd.x){
            counter += 1;
        }
        if (r.sd.y >= ie.y && r.sd.y <= sd.y){
            counter += 1;
        }

        if (counter == 4) {
            return true;
        } else {
            return false;
        }
    }
}

public class ed186 {
    public static void main(String[] args) {
        Point a = new Point(1,1);
        Point b = new Point(2,2);
        Point c = new Point(3,4);
        Point d = new Point(8,2);
        
        Rectangle amarelo  = new Rectangle(a, c);
        Rectangle laranja  = new Rectangle(2, 3, 9, 6);
        Rectangle verde    = new Rectangle(3, 4, 4, 5);
        Rectangle azul     = new Rectangle(5, 1, 6, 5);
        Rectangle vermelho = new Rectangle(7, 3, 9, 5);

        System.out.println("Perimetro do retangulo amarelo = " + amarelo.perimeter()); // 10
        System.out.println("Perimetro do retangulo laranja = " + laranja.perimeter()); // 20
        
        System.out.println("Area do retangulo amarelo = " + amarelo.area()); // 6
        System.out.println("Area do retangulo laranja = " + laranja.area()); // 21        

        System.out.println("Ponto B dentro rectangulo amarelo? " + amarelo.pointInside(b)); // true
        System.out.println("Ponto D dentro rectangulo amarelo? " + amarelo.pointInside(d)); // false

        System.out.println("Retangulo verde dentro do laranja? " + laranja.rectangleInside(verde));       // true
        System.out.println("Retangulo azul dentro do laranja? " + laranja.rectangleInside(azul));         // false
        System.out.println("Retangulo vermelho dentro do laranja? " + laranja.rectangleInside(vermelho)); // true
    }
}