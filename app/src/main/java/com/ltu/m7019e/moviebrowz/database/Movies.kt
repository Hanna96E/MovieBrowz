package com.ltu.m7019e.moviebrowz.database

import com.ltu.m7019e.moviebrowz.model.Genre
import com.ltu.m7019e.moviebrowz.model.Movie
import com.ltu.m7019e.moviebrowz.model.MovieDetail

class Movies {
    val list = mutableListOf<Movie>()

    init {
        list.add(
            Movie(
                502356,
                "The Super Mario Bros. Movie",
                "/qNBAXBIQlnOThrVvA6mA2B5ggV6.jpg",
                "/9n2tJBplPbgR2ca05hS5CKXwP2c.jpg",
                "2023-04-05",
                "While working underground to fix a water main, Brooklyn plumbers—and brothers—Mario and Luigi are transported down a mysterious pipe and wander into a magical new world. But when the brothers are separated, Mario embarks on an epic quest to find Luigi.",
                MovieDetail(
                    502356,
                    "tt6718170",
                    "https://www.thesupermariobros.movie",
                    listOf(
                        Genre(16, 	"Animation"),
                        Genre(12, "Adventure"),
                        Genre(10751, "Family"),
                        Genre(14, "Fantasy"),
                        Genre(35, "Comedy")
                    )
                )
            )
        )
        list.add(
            Movie(
                594767,
                "Shazam! Fury of the Gods",
                "/3GrRgt6CiLIUXUtoktcv1g2iwT5.jpg",
                "/wybmSmviUXxlBmX44gtpow5Y9TB.jpg",
                "2023-03-15",
                "Billy Batson and his foster siblings, who transform into superheroes by saying 'Shazam!', are forced to get back into action and fight the Daughters of Atlas, who they must stop from using a weapon that could destroy the world.",
                MovieDetail(
                    594767,
                    "tt10151854",
                    "",
                    listOf(
                        Genre(28, "Action"),
                        Genre(35, "Comedy"),
                        Genre(14, "Fantasy")
                    )
                )
            )
        )
        list.add(
            Movie(
                76600,
                "Avatar: The Way of Water",
                "/t6HIqrRAclMCA60NsSmeqe9RmNV.jpg",
                "/ytdebEE0ndYLSTEctPgh8e0vaBs.jpg",
                "2022-12-14",
                "Set more than a decade after the events of the first film, learn the story of the Sully family (Jake, Neytiri, and their kids), the trouble that follows them, the lengths they go to keep each other safe, the battles they fight to stay alive, and the tragedies they endure.",
                MovieDetail(
                    76600,
                    "tt1630029",
                    "https://www.avatar.com/movies/avatar-the-way-of-water",
                    listOf(
                        Genre(878, "Science fiction"),
                        Genre(12, "Adventure"),
                        Genre(28, "Action")
                    )
                )
            )
        )
        list.add(
            Movie(
                677179,
                "Creed III",
                "/cvsXj3I9Q2iyyIo95AecSd1tad7.jpg",
                "/5i6SjyDbDWqyun8klUuCxrlFbyw.jpg",
                "2023-03-01",
                "After dominating the boxing world, Adonis Creed has been thriving in both his career and family life. When a childhood friend and former boxing prodigy, Damien Anderson, resurfaces after serving a long sentence in prison, he is eager to prove that he deserves his shot in the ring. The face-off between former friends is more than just a fight. To settle the score, Adonis must put his future on the line to battle Damien — a fighter who has nothing to lose.",
                MovieDetail(
                    677179,
                    "tt11145118",
                    "https://www.mgmstudios.com/creed-iii",
                    listOf(
                        Genre(18, "Drama"),
                        Genre(28, "Action")
                    )
                )
            )
        )
        list.add(
            Movie(
                700391,
                "65",
                "/rzRb63TldOKdKydCvWJM8B6EkPM.jpg",
                "/eSVu1FvGPy86TDo4hQbpuHx55DJ.jpg",
                "2023-03-02",
                "65 million years ago, the only 2 survivors of a spaceship from Somaris that crash-landed on Earth must fend off dinosaurs and reach the escape vessel in time before an imminent asteroid strike threatens to destroy the planet.",
                MovieDetail(
                    700391,
                    "tt12261776",
                    "https://www.65.movie",
                    listOf(
                        Genre(878, "Science fiction"),
                        Genre(12, "Adventure"),
                        Genre(53, "Thriller"),
                        Genre(28, "Action")
                    )
                )
            )
        )
        list.add(
            Movie(
                638974,
                "Murder Mystery 2",
                "/s1VzVhXlqsevi8zeCMG9A16nEUf.jpg",
                "/bT3IpP7OopgiVuy6HCPOWLuaFAd.jpg",
                "2023-03-28",
                "After starting their own detective agency, Nick and Audrey Spitz land a career-making case when their billionaire pal is kidnapped from his wedding.",
                MovieDetail(
                    638974,
                    "tt15255288",
                    "https://www.netflix.com/title/81212842",
                    listOf(
                        Genre(35, "Comedy"),
                        Genre(9648, "Mystery"),
                        Genre(28, "Action")
                    )
                )
            )
        )
        list.add(
            Movie(
                804150,
                "Cocaine Bear",
                "/gOnmaxHo0412UVr1QM5Nekv1xPi.jpg",
                "/a2tys4sD7xzVaogPntGsT1ypVoT.jpg",
                "2023-02-22",
                "Inspired by a true story, an oddball group of cops, criminals, tourists and teens converge in a Georgia forest where a 500-pound black bear goes on a murderous rampage after unintentionally ingesting cocaine.",
                MovieDetail(
                    804150,
                    "tt14209916",
                    "https://www.cocainebear.movie/",
                    listOf(
                        Genre(53, "Thriller"),
                        Genre(35, "Comedy"),
                        Genre(80, "Crime")
                    )
                )
            )
        )
        list.add(
            Movie(
                315162,
                "Puss in Boots: The Last Wish",
                "/kuf6dutpsT0vSVehic3EZIqkOBt.jpg",
                "/ouB7hwclG7QI3INoYJHaZL4vOaa.jpg",
                "2022-12-07",
                "Puss in Boots discovers that his passion for adventure has taken its toll: He has burned through eight of his nine lives, leaving him with only one life left. Puss sets out on an epic journey to find the mythical Last Wish and restore his nine lives.",
                MovieDetail(
                    315162,
                    "tt3915174",
                    "https://www.dreamworks.com/movies/puss-in-boots-the-last-wish",
                    listOf(
                        Genre(16, 	"Animation"),
                        Genre(10751, "Family"),
                        Genre(14, "Fantasy"),
                        Genre(12, "Adventure"),
                        Genre(35, "Comedy")
                    )

                )
            )
        )
        list.add(
            Movie(
                603692,
                "John Wick: Chapter 4",
                "/vZloFAK7NmvMGKE7VkF5UHaz0I.jpg",
                "/h8gHn0OzBoaefsYseUByqsmEDMY.jpg",
                "2023-03-22",
                "With the price on his head ever increasing, John Wick uncovers a path to defeating The High Table. But before he can earn his freedom, Wick must face off against a new enemy with powerful alliances across the globe and forces that turn old friends into foes.",
                MovieDetail(
                    603692,
                    "tt10366206",
                    "https://johnwick.movie",
                    listOf(
                        Genre(28, "Action"),
                        Genre(53, "Thriller"),
                        Genre(80, "Crime")
                    )
                )
            )
        )
        list.add(
            Movie(
                758323,
                "The Pope's Exorcist",
                "/9JBEPLTPSm0d1mbEcLxULjJq9Eh.jpg",
                "/5Y5pz0NX7SZS9036I733F7uNcwK.jpg",
                "2023-04-05",
                "Father Gabriele Amorth, Chief Exorcist of the Vatican, investigates a young boy's terrifying possession and ends up uncovering a centuries-old conspiracy the Vatican has desperately tried to keep hidden.",
                MovieDetail(
                    758323,
                    "tt13375076",
                    "https://www.thepopes-exorcist.movie",
                    listOf(
                        Genre(27, "Horror"),
                        Genre(9648, "Mystery")
                    )
                )
            )
        )

        //////////

        list.add(
            Movie(
                502356,
                "The Super Mario Bros. Movie",
                "/qNBAXBIQlnOThrVvA6mA2B5ggV6.jpg",
                "/9n2tJBplPbgR2ca05hS5CKXwP2c.jpg",
                "2023-04-05",
                "While working underground to fix a water main, Brooklyn plumbers—and brothers—Mario and Luigi are transported down a mysterious pipe and wander into a magical new world. But when the brothers are separated, Mario embarks on an epic quest to find Luigi.",
                MovieDetail(
                    502356,
                    "tt6718170",
                    "https://www.thesupermariobros.movie",
                    listOf(
                        Genre(16, 	"Animation"),
                        Genre(12, "Adventure"),
                        Genre(10751, "Family"),
                        Genre(14, "Fantasy"),
                        Genre(35, "Comedy")
                    )
                )
            )
        )
        list.add(
            Movie(
                594767,
                "Shazam! Fury of the Gods",
                "/3GrRgt6CiLIUXUtoktcv1g2iwT5.jpg",
                "/wybmSmviUXxlBmX44gtpow5Y9TB.jpg",
                "2023-03-15",
                "Billy Batson and his foster siblings, who transform into superheroes by saying 'Shazam!', are forced to get back into action and fight the Daughters of Atlas, who they must stop from using a weapon that could destroy the world.",
                MovieDetail(
                    594767,
                    "tt10151854",
                    "",
                    listOf(
                        Genre(28, "Action"),
                        Genre(35, "Comedy"),
                        Genre(14, "Fantasy")
                    )
                )
            )
        )
        list.add(
            Movie(
                76600,
                "Avatar: The Way of Water",
                "/t6HIqrRAclMCA60NsSmeqe9RmNV.jpg",
                "/ytdebEE0ndYLSTEctPgh8e0vaBs.jpg",
                "2022-12-14",
                "Set more than a decade after the events of the first film, learn the story of the Sully family (Jake, Neytiri, and their kids), the trouble that follows them, the lengths they go to keep each other safe, the battles they fight to stay alive, and the tragedies they endure.",
                MovieDetail(
                    76600,
                    "tt1630029",
                    "https://www.avatar.com/movies/avatar-the-way-of-water",
                    listOf(
                        Genre(878, "Science fiction"),
                        Genre(12, "Adventure"),
                        Genre(28, "Action")
                    )
                )
            )
        )
        list.add(
            Movie(
                677179,
                "Creed III",
                "/cvsXj3I9Q2iyyIo95AecSd1tad7.jpg",
                "/5i6SjyDbDWqyun8klUuCxrlFbyw.jpg",
                "2023-03-01",
                "After dominating the boxing world, Adonis Creed has been thriving in both his career and family life. When a childhood friend and former boxing prodigy, Damien Anderson, resurfaces after serving a long sentence in prison, he is eager to prove that he deserves his shot in the ring. The face-off between former friends is more than just a fight. To settle the score, Adonis must put his future on the line to battle Damien — a fighter who has nothing to lose.",
                MovieDetail(
                    677179,
                    "tt11145118",
                    "https://www.mgmstudios.com/creed-iii",
                    listOf(
                        Genre(18, "Drama"),
                        Genre(28, "Action")
                    )
                )
            )
        )
        list.add(
            Movie(
                700391,
                "65",
                "/rzRb63TldOKdKydCvWJM8B6EkPM.jpg",
                "/eSVu1FvGPy86TDo4hQbpuHx55DJ.jpg",
                "2023-03-02",
                "65 million years ago, the only 2 survivors of a spaceship from Somaris that crash-landed on Earth must fend off dinosaurs and reach the escape vessel in time before an imminent asteroid strike threatens to destroy the planet.",
                MovieDetail(
                    700391,
                    "tt12261776",
                    "https://www.65.movie",
                    listOf(
                        Genre(878, "Science fiction"),
                        Genre(12, "Adventure"),
                        Genre(53, "Thriller"),
                        Genre(28, "Action")
                    )
                )
            )
        )
        list.add(
            Movie(
                638974,
                "Murder Mystery 2",
                "/s1VzVhXlqsevi8zeCMG9A16nEUf.jpg",
                "/bT3IpP7OopgiVuy6HCPOWLuaFAd.jpg",
                "2023-03-28",
                "After starting their own detective agency, Nick and Audrey Spitz land a career-making case when their billionaire pal is kidnapped from his wedding.",
                MovieDetail(
                    638974,
                    "tt15255288",
                    "https://www.netflix.com/title/81212842",
                    listOf(
                        Genre(35, "Comedy"),
                        Genre(9648, "Mystery"),
                        Genre(28, "Action")
                    )
                )
            )
        )
        list.add(
            Movie(
                804150,
                "Cocaine Bear",
                "/gOnmaxHo0412UVr1QM5Nekv1xPi.jpg",
                "/a2tys4sD7xzVaogPntGsT1ypVoT.jpg",
                "2023-02-22",
                "Inspired by a true story, an oddball group of cops, criminals, tourists and teens converge in a Georgia forest where a 500-pound black bear goes on a murderous rampage after unintentionally ingesting cocaine.",
                MovieDetail(
                    804150,
                    "tt14209916",
                    "https://www.cocainebear.movie/",
                    listOf(
                        Genre(53, "Thriller"),
                        Genre(35, "Comedy"),
                        Genre(80, "Crime")
                    )
                )
            )
        )
        list.add(
            Movie(
                315162,
                "Puss in Boots: The Last Wish",
                "/kuf6dutpsT0vSVehic3EZIqkOBt.jpg",
                "/ouB7hwclG7QI3INoYJHaZL4vOaa.jpg",
                "2022-12-07",
                "Puss in Boots discovers that his passion for adventure has taken its toll: He has burned through eight of his nine lives, leaving him with only one life left. Puss sets out on an epic journey to find the mythical Last Wish and restore his nine lives.",
                MovieDetail(
                    315162,
                    "tt3915174",
                    "https://www.dreamworks.com/movies/puss-in-boots-the-last-wish",
                    listOf(
                        Genre(16, 	"Animation"),
                        Genre(10751, "Family"),
                        Genre(14, "Fantasy"),
                        Genre(12, "Adventure"),
                        Genre(35, "Comedy")
                    )

                )
            )
        )
        list.add(
            Movie(
                603692,
                "John Wick: Chapter 4",
                "/vZloFAK7NmvMGKE7VkF5UHaz0I.jpg",
                "/h8gHn0OzBoaefsYseUByqsmEDMY.jpg",
                "2023-03-22",
                "With the price on his head ever increasing, John Wick uncovers a path to defeating The High Table. But before he can earn his freedom, Wick must face off against a new enemy with powerful alliances across the globe and forces that turn old friends into foes.",
                MovieDetail(
                    603692,
                    "tt10366206",
                    "https://johnwick.movie",
                    listOf(
                        Genre(28, "Action"),
                        Genre(53, "Thriller"),
                        Genre(80, "Crime")
                    )
                )
            )
        )
        list.add(
            Movie(
                758323,
                "The Pope's Exorcist",
                "/9JBEPLTPSm0d1mbEcLxULjJq9Eh.jpg",
                "/5Y5pz0NX7SZS9036I733F7uNcwK.jpg",
                "2023-04-05",
                "Father Gabriele Amorth, Chief Exorcist of the Vatican, investigates a young boy's terrifying possession and ends up uncovering a centuries-old conspiracy the Vatican has desperately tried to keep hidden.",
                MovieDetail(
                    758323,
                    "tt13375076",
                    "https://www.thepopes-exorcist.movie",
                    listOf(
                        Genre(27, "Horror"),
                        Genre(9648, "Mystery")
                    )
                )
            )
        )
    }
}