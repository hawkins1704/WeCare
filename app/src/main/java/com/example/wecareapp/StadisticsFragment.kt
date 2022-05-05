package com.example.wecareapp

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androidplot.xy.*
import com.demo.retrofitwithpost.GetEventsVM
import com.example.wecareapp.model.Event
import com.example.wecareapp.model.EventGet
import com.example.wecareapp.model.EventList
import com.example.wecareapp.recyclerview.RecyclerViewAdapter
import com.example.wecareapp.viewmodel.CreateEventVM
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartModel
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartType
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartView
import com.github.aachartmodel.aainfographics.aachartcreator.AASeriesElement
import java.text.FieldPosition
import java.text.Format
import java.text.ParsePosition
import java.util.*
import kotlin.collections.ArrayList


class StadisticsFragment : Fragment(){

    // TODO: Rename and change types of parameters

    lateinit var viewModel: GetEventsVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view=inflater.inflate(R.layout.fragment_stadistics, container, false)


        val aaChartView:AAChartView = view.findViewById(R.id.aa_chart_view)
        val aaChartView2:AAChartView = view.findViewById(R.id.aa_chart_view2)
        val aaChartView3:AAChartView = view.findViewById(R.id.aa_chart_view3)

        val aaChartModelEstadoAnimo : AAChartModel = AAChartModel()
            .categories(arrayOf("lunes","martes","miercoles","jueves","viernes","sabado","domingo"))
            .chartType(AAChartType.Line)
            .title("Estado de ánimo registrado")
            .backgroundColor("#FAFAFA")
            .dataLabelsEnabled(true)
            .series(arrayOf(
                AASeriesElement()
                    .name("Estado de ánimo")
                    .data(arrayOf(7.0, 6.0, 4.0, 8.0, 7.0, 5.0, 2.0)),
            )
            )

        val aaChartModelHearRate : AAChartModel = AAChartModel()
            .chartType(AAChartType.Line)
            .title("Ritmo Cardíaco")
            .backgroundColor("#FAFAFA")
            .dataLabelsEnabled(true)
            .series(arrayOf(
                AASeriesElement()
                    .name("Ritmo Cardíaco")
                    .data(arrayOf(70, 68, 64, 91, 82, 75, 92)),
            )
            )

        val aaChartModelBloodPressure : AAChartModel = AAChartModel()
            .chartType(AAChartType.Line)
            .title("Presión Arterial")
            .backgroundColor("#FAFAFA")
            .dataLabelsEnabled(true)
            .series(arrayOf(
                AASeriesElement()
                    .name("Sistólica")
                    .data(arrayOf(118, 129, 120, 119, 143, 115, 125)),
                AASeriesElement()
                    .name("Diastólica")
                    .data(arrayOf(72, 79, 70, 76, 76, 62, 75)),
            )
            )


        aaChartView.aa_drawChartWithChartModel(aaChartModelEstadoAnimo)
        aaChartView2.aa_drawChartWithChartModel(aaChartModelHearRate)
        aaChartView3.aa_drawChartWithChartModel(aaChartModelBloodPressure)
        // Inflate the layout for this fragment

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FeelingFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            StadisticsFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }



}