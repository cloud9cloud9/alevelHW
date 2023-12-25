package ua.nalezhytyi.hw7;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
public class Vector {
    public double xCoord;
    public double yCoord;
    public double zCoord;

    Vector(int x, int y, int z) {
        xCoord = x;
        yCoord = y;
        zCoord = z;
    }

    // метод, вычисляющий длину вектора
    public double getMagnitudeVector(Vector o) {

        double getLongestVector = ((xCoord * xCoord) + (yCoord * yCoord) + (zCoord * zCoord));
        return Math.sqrt(getLongestVector);
    }

    public static void main(String[] args) {
        Vector vector = new Vector(10, 8, 6);
        System.out.println(vector.getMagnitudeVector(vector));
        Vector vectorSecond = new Vector(0, 15, 3);
        System.out.println("Сума двох векторів: " + vector.vectorProduct(vectorSecond));
        System.out.println("Косинус кута між двома векторами: " + vector.cosineAngle(vectorSecond));
        System.out.println("Сума векторів: " + vector.add(vectorSecond));
        System.out.println("Різниця векторів: " + vector.minus(vectorSecond));
        Vector[] vectorArray = new Vector[0];
        vectorArray = arrayOfVectors(5);
        System.out.println(Arrays.toString(printVectorsNextStr(vectorArray)));
    }

    //метод, вычисляющий векторное произведение с другим вектором
    public Vector vectorProduct(Vector otherVector) {
        double newX = this.yCoord * otherVector.zCoord - this.zCoord * otherVector.yCoord;
        double newY = this.zCoord * otherVector.xCoord - this.xCoord * otherVector.zCoord;
        double newZ = this.xCoord * otherVector.yCoord - this.yCoord * otherVector.xCoord;
        return new Vector((int) newX, (int) newY, (int) newZ);
    }

    @Override
    public String toString() {
        return "Vector{" +
                "xCoord=" + xCoord +
                ", yCoord=" + yCoord +
                ", zCoord=" + zCoord +
                '}';
    }

    //метод, вычисляющий косинус угла между векторами: косинус угла между
    // векторами равен скалярному произведению векторов, деленному на произведение модулей
    public double cosineAngle(Vector otherVector) {
        double dotProduct = this.xCoord * otherVector.xCoord + this.yCoord * otherVector.yCoord + this.zCoord * otherVector.zCoord;
        // Обчислення довжин векторів
        double magnitude1 = Math.sqrt(this.xCoord * this.xCoord + this.yCoord * this.yCoord + this.zCoord * this.zCoord);
        double magnitude2 = Math.sqrt(otherVector.xCoord * otherVector.xCoord + otherVector.yCoord * otherVector.yCoord + otherVector.zCoord * otherVector.zCoord);
        // Обчислення косинуса кута
        double cosine = dotProduct / (magnitude1 * magnitude2);
        return cosine;
    }

    //методы для суммы и разности векторов
    public Vector add(Vector otherVector) {
        double newX = this.xCoord + otherVector.xCoord;
        double newY = this.yCoord + otherVector.yCoord;
        double newZ = this.zCoord + otherVector.zCoord;
        return new Vector((int) newX, (int) newY, (int) newZ);
    }

    public Vector minus(Vector otherVector) {
        double newX = this.xCoord - otherVector.xCoord;
        double newY = this.yCoord - otherVector.yCoord;
        double newZ = this.zCoord - otherVector.zCoord;
        return new Vector((int) newX, (int) newY, (int) newZ);
    }

    //статический метод, который принимает целое число n, и возвращает массив случайных
    //векторов размером n.
    public static Vector[] arrayOfVectors(int n) {
        Vector[] array = new Vector[n];
        for (int i = 0; i < n; i++) {
            double x = ThreadLocalRandom.current().nextInt(1, 100);
            double y = ThreadLocalRandom.current().nextInt(1, 100);
            double z = ThreadLocalRandom.current().nextInt(1, 100);
            array[i] = new Vector((int) x, (int) y, (int) z);
        }
        return array;
    }

    public static int[] printVectorsNextStr(Vector[] array) {
        for (int i = 0; i < array.length; i++) {
            Vector vector = array[i];
            System.out.println("Вектор " + (i + 1) + ": (" + vector.xCoord + ", " + vector.yCoord + ", " + vector.zCoord + ")");
        }
        return new int[0];
    }
}

