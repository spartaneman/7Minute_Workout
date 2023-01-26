package com.example.a7minute_workout
/**
 * Exercise class
 * **/
class ExerciseModel(private var id: Int, private var name: String,
                    private var image: Int, private var isComleted: Boolean,
                    private var isSelected: Boolean){

    fun getId(): Int{
        return id
    }

    fun setId(id: Int)
    {
        this.id = id
    }

    fun getName(): String
    {
        return name
    }

    fun setName(name: String)
    {
        this.name = name
    }
    fun setImage(image: Int)
    {
        this.image = image
    }

    fun getImage(): Int
    {
        return image
    }

    fun setCompleted(complete: Boolean)
    {
        this.isComleted = complete
    }

    fun getCompleted():Boolean
    {
        return isComleted
    }
    fun setSelected(selected: Boolean)
    {
        this.isSelected = selected
    }

    fun getSelected():Boolean
    {
        return isSelected
    }
}


