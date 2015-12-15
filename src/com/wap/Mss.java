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

/**
 * Created by liu on 12/15/15.
 */
public class Mss {

    public static void main(String[] args) {
        // test with an example
        int[] xs = {-4, -3, 7, 2, -1, 2, -1, -4};

        System.out.println(mss(xs));
    }

    private static int mss(int[] xs) {
        int sum =0;
        int mss =0;
        for(int x : xs){
            sum+=x;
            if(sum > mss) mss = sum;
            if(sum <0) sum =0;
        }
        return mss;
    }

}
