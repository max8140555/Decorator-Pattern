package com.max.decoratorpattern

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.max.decoratorpattern.part1.component.Beverage
import com.max.decoratorpattern.part1.component.componentimpl.MilkTea
import com.max.decoratorpattern.part1.component.decorator.decoratorimpl.BubbleDecorator
import com.max.decoratorpattern.part1.component.decorator.decoratorimpl.PuddingDecorator
import com.max.decoratorpattern.part2.component.DataSource
import com.max.decoratorpattern.part2.component.componentimpl.FileDataSource
import com.max.decoratorpattern.part2.component.decorator.decoratorimpl.CompressionDecorator
import com.max.decoratorpattern.part2.component.decorator.decoratorimpl.EncryptionDecorator

class MainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        part1()
        part2()
    }

    /**
     * part-1
     * 以創建飲料訂單為範例
     */
    private fun part1() {
        var milkTea: Beverage = MilkTea()

        Log.d("Max123", "${milkTea.getDescription()} is cost ${milkTea.cost()}")

        milkTea = PuddingDecorator(BubbleDecorator(milkTea))

        Log.d("Max123", "${milkTea.getDescription()} is cost ${milkTea.cost()}")
    }

    /**
     * part-2
     * 以讀寫 Cache 為範例
     */
    private fun part2() {
        // 讀寫
        // FileDataSource
        var fileDataSource: DataSource = FileDataSource(this, "Max_Cache")

        // 加密 ＋ 讀寫
        // EncryptionDecorator -> FileDataSource
        fileDataSource = EncryptionDecorator(fileDataSource)

        // 壓縮 ＋ 加密 ＋ 讀寫
        // CompressionDecorator -> EncryptionDecorator -> FileDataSource
        fileDataSource = CompressionDecorator(fileDataSource)
        fileDataSource.writeData("Max")

        Log.d("Max123", "CompressionDecorator readData : ${fileDataSource.readData()}")
    }
}