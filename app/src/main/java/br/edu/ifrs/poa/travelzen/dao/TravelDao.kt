package br.edu.ifrs.poa.travelzen.dao

import br.edu.ifrs.poa.travelzen.model.Travel

class TravelDao {

    fun add(travel: Travel){
        travels.add(travel)
    }

    fun listAll(): List<Travel> {
        return travels.toList()
    }

    companion object{
        private val travels = mutableListOf<Travel>()
    }

}