package com.example.vaelfardsapp.constants

import com.example.vaelfardsapp.R
import com.example.vaelfardsapp.models.QuestionModel

object Questions {
    fun getQuestions(): ArrayList<QuestionModel> {
        return arrayListOf(
            QuestionModel(
                "Kreativitet",
                "Du tænker tit ‘Hmm, gad vide, om det kan gøres på en ny eller smartere måde?’ Du er god til at få idéer.",
                R.drawable.kreativitet, R.raw.introvid
            ),
            QuestionModel(
                "Nysgerrighed",
                "Du elsker at stille spørgsmål og fordybe dig. Ligesom Spørge Jørgen, der altid spørger “hvorfor dit og hvorfor dat”.",
                R.drawable.nysgerrighed, R.raw.introvid
            ),
            QuestionModel(
                "Dømmekraft",
                "Du er god til at se ting fra flere vinkler. Du er grundig og drager sjældent forhastede konklusioner.",
                R.drawable.doemmekraft, R.raw.introvid
            ),
            QuestionModel(
                "Videbegær",
                "Du elsker at lære nye ting. Du suger viden til dig både i skolen og i fritiden.",
                R.drawable.videbegaer, R.raw.introvid
            ),
            QuestionModel(
                "Visdom",
                "Dine venner kommer tit til dig for at få gode råd. Du er nemlig god til at åbne nye perspektiver.",
                R.drawable.visdom, R.raw.introvid
            ),
            QuestionModel(
                "Mod",
                "Du er ikke bange for at kaste dig ud i nye udfordringer. Du siger din mening og tør at gå egne veje.",
                R.drawable.mod, R.raw.introvid
            ),
            QuestionModel(
                "Vedholdenhed",
                "Du giver ikke op. Når du går i gang med noget, så gør du det færdigt. Også selvom det trækker tænder ud.",
                R.drawable.vedholdenhed, R.raw.introvid
            ),
            QuestionModel(
                "Ærlighed",
                "Du taler sandt. Samtidig gør du sjældent ting, der strider imod dine værdier og principper.",
                R.drawable.aerlighed, R.raw.introvid
            ),
            QuestionModel(
                "Entusiasme",
                "Når du bliver optaget af noget, går du 100 % ind i det. Du er fuld af begejstring og engagement.",
                R.drawable.entusiasme, R.raw.introvid
            ),
            QuestionModel(
                "Relationer",
                "Du er god til at knytte tætte bånd til andre. Det betyder meget for dig at være tæt på folk, du holder af.",
                R.drawable.relationer, R.raw.introvid
            ),
            QuestionModel(
                "Omsorg",
                "Du står klar, når folk omkring dig har brug for hjælp. Du tænker på andre og spreder varme.",
                R.drawable.omsorg, R.raw.introvid
            ),
            QuestionModel(
                "Social intelligens",
                "Du er god til at leve dig ind i andre. Folk omkring dig føler sig godt tilpas i dit selskab.",
                R.drawable.socialintelligens, R.raw.introvid
            ),
            QuestionModel(
                "Værdsættelse",
                "Du er god til at få øje på det smukke i livet. Om det er et flot landskab eller et perfekt saksespark, så er du helt solgt.",
                R.drawable.vaerdsaettelse, R.raw.introvid
            ),
            QuestionModel(
                "Taknemmelighed",
                "Du sætter pris på både små og store ting i livet. ‘Tak’ er et af dine yndlingsord. Folk omkring dig ved, at de betyder noget for dig.",
                R.drawable.taknemmelighed, R.raw.introvid
            ),
            QuestionModel(
                "Optimisme",
                "Du ser det gode i livet – også selvom tingene ikke altid går din vej. Du ser lyst på fremtiden. Tænker ‘Det skal nok gå’.",
                R.drawable.optimisme, R.raw.introvid
            ),
            QuestionModel(
                "Humor",
                "Du tager ikke ting så tungt. Du er god til at se ting fra en skæv vinkel og skabe smil omkring dig.",
                R.drawable.humor, R.raw.introvid
            ),
            QuestionModel(
                "Spiritualitet",
                "Du ved, at du er en del af noget større. Du er åben for, at ting kan hænge sammen på mange måder.",
                R.drawable.spiritualitet, R.raw.introvid
            ),
            QuestionModel(
                "Samarbejde",
                "Andre kan regne med dig. Du er god til at få grupper til at fungere og nyder fællesskaber.",
                R.drawable.samarbejde, R.raw.introvid
            ),
            QuestionModel(
                "Retfærdighed",
                "Det er vigtigt for dig, at andre bliver behandlet ordentligt – også selvom du ikke nødvendigvis er enig med dem.",
                R.drawable.retfaerdighed, R.raw.introvid
            ),
            QuestionModel(
                "Lederskab",
                "Du kan godt lide at gå forrest og tager ofte styringen i en gruppe. Andre lytter til dig og er tit med på dine idéer.",
                R.drawable.lederskab, R.raw.introvid
            ),
            QuestionModel(
                "Tilgivelse",
                "Du bærer ikke nag, når andre sårer dig. Du ved, at alle begår fejl. Hos dig får folk en ny chance.",
                R.drawable.tilgivelse, R.raw.introvid
            ),
            QuestionModel(
                "Beskedenhed",
                "Du er ikke typen, der råber “Se mig! Se mig!” Heller ikke når alting bare kører for dig.",
                R.drawable.beskedenhed, R.raw.introvid
            ),
            QuestionModel(
                "Omtanke",
                "Du tænker dig om, inden du gør eller siger noget. Du er en grundig person, der træffer fornuftige valg.",
                R.drawable.omtanke, R.raw.introvid
            ),
            QuestionModel(
                "Selvkontrol",
                "Du har stor selvdisciplin. Følelser og impulser løber sjældent af med dig.",
                R.drawable.selvkontrol, R.raw.introvid
            )
        )
    }
}