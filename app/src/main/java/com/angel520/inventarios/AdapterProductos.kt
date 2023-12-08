package com.angel520.inventarios

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterProductos(private var listproductos: List<Productos>) : RecyclerView.Adapter<AdapterProductos.InventarioViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int ): InventarioViewHolder {

        val inflater = LayoutInflater.from(parent.context)

        val view = inflater.inflate(R.layout.item_lista, parent, false)
        return  InventarioViewHolder(view)

    }

    override fun onBindViewHolder(holder: InventarioViewHolder, position: Int) {
        val listProductos = listproductos[position]
        holder.render(listProductos)
    }

    override fun getItemCount(): Int {
        return listproductos.size
    }

    class InventarioViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val name: TextView = view.findViewById(R.id.device_name_content)
        val precio: TextView = view.findViewById(R.id.ip_address_content)
        val existencia: TextView = view.findViewById(R.id.mac_address_content)


        fun render(networkDevice: Productos) {
            name.text = networkDevice.name
            precio.text = networkDevice.Precio
            existencia.text = networkDevice.Existencia
        }

    }

}