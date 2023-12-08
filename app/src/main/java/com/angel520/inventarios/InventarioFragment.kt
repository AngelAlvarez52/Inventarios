package com.angel520.inventarios

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton


class InventarioFragment : Fragment(), AddBottomSheetFragment.OnAddDeviceListener {

    private var networkDevices: MutableList<Productos> = mutableListOf()
    private lateinit var adapter: AdapterProductos
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =  inflater.inflate(R.layout.fragment_inventario, container, false)
        val buttonDialog = view.findViewById<FloatingActionButton>(R.id.fab_add_device)

        initData()

        val recyclerView = view.findViewById<RecyclerView>(R.id.ProductosDeviceRecycler)
        adapter = AdapterProductos(networkDevices)
        val layoutManager = LinearLayoutManager(container?.context)

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter

        buttonDialog.setOnClickListener {
            this.showAddDeviceBottomSheet()
        }

        return  view;
    }


    private fun showAddDeviceBottomSheet() {
        val bottomSheet = AddBottomSheetFragment().apply {
            setOnAddDeviceListener(this@InventarioFragment)
        }
        bottomSheet.show(parentFragmentManager, "AddNetworkDeviceBottomSheetTag")
    }

    override fun onDeviceAdded(device: Productos) {
        networkDevices.add(device)
        adapter.notifyDataSetChanged()
    }


    private fun initData() {

        networkDevices = mutableListOf(
            Productos(1, "Emperador", "20", "12"),
            Productos(2, "Ruffles", "20", "20"),
            Productos(3, "Gomitas", "8", "100"),
            Productos(4, "Tostitos", "20", "12"),
            Productos(5, "Doritos", "20", "20"),
            Productos(6, "Tortillas", "8", "100"),
            Productos(7, "Frijoles", "20", "12"),
            Productos(8, "Arroz", "20", "20"),
            Productos(9, "Pan", "8", "100"),


            )

    }

}