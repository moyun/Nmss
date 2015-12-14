/*
 * Copyright (C) 2015 Yu Liu <liu_yu@worksap.co.jp>
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

package com.wap;

import java.util.Arrays;
import java.util.Optional;

public class Mnss {

    static int max(int a, int b) {
        return Math.max(a, b);
    }

    public static class Quadruple {
        int[] data;

        public Quadruple() {
            data = new int[4];
        }

        public Quadruple(int a, int b, int c, int d) {
            data = new int[4];
            data[0] = a;
            data[1] = b;
            data[2] = c;
            data[3] = d;
        }

        public Quadruple(int[] qd) {
            assert (qd.length >= 4);
            data = Arrays.copyOf(qd, 4);
        }

        public int get(int n) {
            return Optional.ofNullable(data[n]).orElse(null);
        }
    }

    static int fourth(Quadruple quadruple) {
        return Optional.of(quadruple.get(3)).orElseThrow(() -> new IllegalStateException("must be a quadruple"));
    }

    static Quadruple h(Quadruple qd, int x) {
        return new Quadruple(qd.get(0), max(qd.get(1), qd.get(0)) + x, max(qd.get(2), qd.get(1)), max(qd.get(3), max(qd.get(3), qd.get(2))+ x) );
    }

    static Quadruple start(int[] tuple) {
        assert tuple.length == 3;
        return new Quadruple(0, max(max(tuple[0] + tuple[1] + tuple[2], tuple[1] + tuple[2]), tuple[2]), max(max(tuple[0], tuple[0] + tuple[1]), tuple[1]), tuple[0] + tuple[2]);
    }

    static int[] take(int n, int[] xs) {
        int min = Math.min(n, xs.length);
        return Arrays.copyOfRange(xs, 0, min);
    }

    static int[] drop(int n, int[] xs) {
        int min = Math.min(n, xs.length);
        return Arrays.copyOfRange(xs, min, xs.length);
    }

    static int mnss(final int[] xs) {
        return (fourth(foldl_h((start(take(3, xs))), drop(3, xs))));
    }

    /**
     * specialized foldl
     *
     * @return
     */
    static  Quadruple foldl_h(Quadruple start, int[] ys) {

        Quadruple qd = new Quadruple(start.data);
        for (int y : ys) {
            qd = h(qd,y);
        }
        return qd;
    }


    public static void main(String[] args) {
        // test with an example
        int[] xs ={-4,-3,7,2,1,-2,-1,-4};

        System.out.println(mnss(xs));
    }
}
