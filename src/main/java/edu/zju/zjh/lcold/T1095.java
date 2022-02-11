package main.java.edu.zju.zjh.lcold;

interface MountainArray {
    public int get(int index);

    public int length();
}


class MountainArrayImpl implements MountainArray {
    private int[] arr;
    private int size;

    public MountainArrayImpl(int[] arr) {
        this.arr = arr;
        this.size = this.arr.length;
    }

    @Override
    public int get(int index) {
        return this.arr[index];
    }

    @Override
    public int length() {
        return this.size;
    }

}

public class T1095 {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int top;
        int left, right, mid;

        left = 0;
        right = mountainArr.length() - 1;
        while (left < right) {
            mid = (left + right) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        top = mountainArr.get(left) > mountainArr.get(right) ? left : right;

        left = 0;
        right = top;
        while (left < right) {
            mid = (left + right) / 2;
            if (mountainArr.get(mid) < target) {
                left = mid + 1;
            } else if (mountainArr.get(mid) > target) {
                right = mid;
            } else {
                return mid;
            }
        }
        if (mountainArr.get(left) == target) {
            return left;
        }


        left = top;
        right = mountainArr.length() - 1;
        while (left < right) {
            mid = (left + right) / 2;
            if (mountainArr.get(mid) > target) {
                left = mid + 1;
            } else if (mountainArr.get(mid) < target) {
                right = mid;
            } else {
                return mid;
            }
        }
        if (mountainArr.get(left) == target) {
            return left;
        }

        return -1;
    }

    public static void main(String[] args) {
        MountainArray m = new MountainArrayImpl(new int[]{1, 5, 2});

        System.out.println(new T1095().findInMountainArray(2, m));
    }
}
