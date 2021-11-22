package com.example.vaelfardsapp.constants

import com.example.vaelfardsapp.R
import com.example.vaelfardsapp.models._questionModel

object _Questions {
    fun getQuestions(): ArrayList<_questionModel> {
        return arrayListOf(
            _questionModel("Ærlighed", "Cat ipsum dolor sit amet, paw your face to wake you up in the morning yet human is in bath tub, emergency! drowning! meooowww!", R.raw.introvid),
            _questionModel("Visdom", "Prow scuttle parrel provost Sail ho shrouds spirits boom mizzenmast yardarm. Pinnace holystone mizzenmast quarter crow's nest nipperkin grog yardarm hempen halter furl. Swab barque interloper chantey doubloon starboard grog black jack gangway rutters.", R.raw.introvid),
            _questionModel("Spiritualitet", "Cupcake ipsum dolor sit amet pie. Jelly biscuit marshmallow muffin croissant. Gummies cake brownie caramels chocolate bar ice cream. Muffin lollipop brownie gummies tart jelly icing pudding.", R.raw.introvid),
            _questionModel("Lederskab", "Good man. Nixon's pro-war and pro-family. Leela, Bender, we're going grave robbing. Why, those are the Grunka-Lunkas! They work here in the Slurm factory. You are the last hope of the universe.", R.raw.introvid),
            _questionModel("Relationer", "Radical candor cadence. Programmatically paddle on both sides message the initiative, radical candor. Eat our own dog food. Crank this out. Baseline show pony. Come up with something buzzworthy.", R.raw.introvid)
        )
    }
}