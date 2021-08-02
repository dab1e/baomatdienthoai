package com.dab1e.bomtcucgi.model

import com.dab1e.bomtcucgi.R

class Pass {

    private val pass = arrayOf(1,2,3,4)
    private var inputpass = arrayOf(10,10,10,10)

    var background:Int = R.drawable.white_round_border
    var suc:Boolean = false
    var position:Int = 0

    fun setPassWord(number:Int){
        checkposition()
        if(position==3) {
            checkPassWord()
        }
        else {
            for (i in 0..3) {
                if (inputpass[i]==10) {
                    inputpass[i] = number
                    position = i
                    background = R.drawable.white_circle
                    suc = false
                    if(i==3) {
                        checkPassWord()
                    }
                    break
                }
            }
        }
    }
    fun deletepass(){
        checkposition()
        inputpass[position!!] = 10
        background = R.drawable.white_round_border

    }

    fun checkPassWord(){

        var boo:Boolean = false
        for (i in 0..3){
            if(inputpass[i]==pass[i]) boo = true
            else boo = false
        }
        if (boo==true) {
            suc = true
            inputpass = arrayOf(10, 10, 10, 10)
        }else{
            inputpass = arrayOf(10, 10, 10, 10)
        }
    }
    fun checkposition(){
        for (i in 0..3){
            position=0
            if(inputpass[i]==10) {
                position = i-1
                break
            }
        }
    }
}
