package com.puhovdev.appforsearhfilms

import android.os.Bundle
import android.transition.Scene
import android.transition.Slide
import android.transition.TransitionManager
import android.transition.TransitionSet
import android.view.*
import androidx.fragment.app.Fragment
import android.view.animation.AnimationUtils
import android.widget.SearchView
import androidx.databinding.DataBindingUtil
import com.puhovdev.appforsearhfilms.databinding.FragmentHomeBinding
import com.puhovdev.appforsearhfilms.databinding.MergeHomeScreenContentBinding
import java.util.*

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var bindingMHSC: MergeHomeScreenContentBinding
    private lateinit var filmsAdapter: FilmListRecyclerAdapter

    private val filmsDataBase = listOf(
        Film(
            1,
            "Чем мы заняты в тени",
            "Три вампира делят дом, решают бытовые конфликты, ищут любовь — и свежую кровь, без которой им не прожить.",
            2019,
            R.drawable.pstr_shadow
        ),
        Film(
            2,
            "Пятница 13-е ",
            "Компания друзей - Уитни, Майк, Ричи, Аманда и Уэйд - заблудилась в лесах около заброшенного лагеря «Хрустальное озеро». Когда их любопытство взяло верх, они решили посетить то место, где когда-то обитал убийца-психопат. Тем временем Трент приглашает друзей, Джену, Брии, Чеви, Челси, Лоуренса и Нолана, в свою хижину, расположенную у озера, на уик-энд, полный секса, алкоголя и наркотиков. Забавный уик-энд перерастает в кошмар после того, как одинокий путешественник Клэй начинает поиски своей пропавшей сестры Уитни.",
            2009,
            R.drawable.pstr_friday_13
        ),
        Film(
            3,
            "Аватар",
            "Бывший морпех Джейк Салли прикован к инвалидному креслу. Несмотря на немощное тело, Джейк в душе по-прежнему остается воином. Он получает задание совершить путешествие в несколько световых лет к базе землян на планете Пандора, где корпорации добывают редкий минерал, имеющий огромное значение для выхода Земли из энергетического кризиса.",
            2009,
            R.drawable.pstr_avatar
        ),
        Film(
            4,
            "Достать ножи ",
            "На следующее утро после празднования 85-летия известного автора криминальных романов Харлана Тромби виновника торжества находят мёртвым. Налицо — явное самоубийство, но полиция по протоколу опрашивает всех присутствующих в особняке членов семьи, хотя, в этом деле больше заинтересован частный детектив Бенуа Блан. Тем же утром он получил конверт с наличными от неизвестного и заказ на расследование смерти Харлана. Не нужно быть опытным следователем, чтобы понять, что все приукрашивают свои отношения с почившим главой семейства, но Блану достаётся настоящий подарок — медсестра покойного, которая физически не выносит ложь.",
            2019,
            R.drawable.pstr_dostat_nozhy
        ),
        Film(
            5,
            "Офис",
            "Сериал о трудовых буднях небольшого регионального офиса крупной компании, обитатели которого целыми днями должны терпеть закидоны своего непутевого босса.",
            2005,
            R.drawable.pstr_office
        ),
        Film(
            6,
            "Очень странные дела",
            "1980-е годы, тихий провинциальный американский городок. Благоприятное течение местной жизни нарушает загадочное исчезновение подростка по имени Уилл. Выяснить обстоятельства дела полны решимости родные мальчика и местный шериф, также события затрагивают лучшего друга Уилла – Майка. Он начинает собственное расследование. Майк уверен, что близок к разгадке, и теперь ему предстоит оказаться в эпицентре ожесточенной битвы потусторонних сил.",
            2016,
            R.drawable.pstr_stranger_things
        ),
        Film(
            7,
            "Парк Юрского периода",
            "Экспансивный богач и профессор уговаривает двух палеонтологов приехать на остров у побережья Коста-Рики, где он устроил парк Юрского периода. Парк населен давно вымершими динозаврами, воссозданными профессором по образцам крови из ископаемого комара, которые должны стать гвоздем программы нового аттракциона. До открытия остается несколько дней, а один из сотрудников, пытаясь украсть бесценные эмбрионы, нарушает систему охраны, что вместе с грозовым ливнем приводит к отключению электричества и защитных барьеров. Как раз в тот момент, когда палеонтологи с внуками профессора отправились на пробную экскурсию.",
            1993,
            R.drawable.pstr_jurrasic_park
        ),
        Film(
            8,
            "Кинг Конг",
            "В 1930-м году съемочная группа под предводительством режиссера-неудачника Карла Дэнхэма отправляется на загадочный Остров Черепа неподалеку от Суматры, чтобы изучать легенды о гигантской горилле по кличке Конг. По прибытии на место они обнаруживают, что Кинг Конг и правда существует. Горилла живет в самой чаще непроходимых джунглей, где помимо него, спрятанные от всего мира, обитают многие создания из доисторических времен. Исследователи оказываются между двух огней - с одной стороны Кинг Конг, а с другой - его враги динозавры...",
            2005,
            R.drawable.pstr_shadow
        ),
        Film(
            9,
            "Самый пьяный округ в мире ",
            "Действие в картине разворачивается на американском Юге во времена сухого закона и Великой Депрессии. В центре сюжета – семья Бондурант, три брата, Джек, Форрест и Говард, которые занимаются запрещенным в то время бизнесом, бутлегерством. Оптимистично настроенный Джек, самый молодой из братьев, надеется с помощью бутлегерства заработать денег и произвести впечатление на свою девушку Берту. В это же время Форрест, напротив, настроен очень мрачно, он молчалив и подозрителен, а Говарду к тому же часто приходится иметь дело с врагами незаконного семейного бизнеса, в лице которых выступают коррумпированные местные полицейские.",
            2012,
            R.drawable.pstr_lawless
        ),
        Film(
            10,
            "Час пик",
            "В Лос-Анджелесе злодеи похищают малолетнюю дочь китайского консула, которую в Гонконге учил кунг-фу инспектор Ли. Консул вызывает Ли в Америку, чтобы тот принял участие в освобождении девочки. Агенты ФБР обратились к полиции с просьбой выделить им самого никчемного сотрудника, чтобы тот взял китайца на себя и показал ему достопримечательности, а главное, не позволил вмешиваться в их дела. Им оказывается самый болтливый полицейский Картер. Естественно, после ряда разногласий и недоразумений они объединяют усилия и всерьез берутся за вызволение заложницы.",
            1998,
            R.drawable.pstr_rush_hour
        ),
        Film(
            11,
            "Копы в глубоком запасе",
            "Нью-Йоркские детективы Аллен Гэмбл и Терри Хойтз ведут полицейскую бухгалтерию. Гэмблу такая работа в радость, Хойтзу — наказание. Когда напарникам представится шанс выйти из тени — прийти на помощь своим кумирам, детективам Дэнсону и Манцетти — станет ясно, что в бухгалтерию Гэмбла и Хойтза сослали не зря…",
            2010,
            R.drawable.pstr_the_other_guys
        ),
        Film(
            12,
            "Ральф",
            "Ральф – второстепенный персонаж восьмибитной компьютерной игры, и ему надоело находиться в тени главного героя, мастера на все руки Феликса, который всегда появляется, чтобы «исправить» ситуацию! После тридцати лет добросовестной работы в роли злодея, в течение которых все похвалы выпадали на долю Феликса, Ральф больше не хочет быть плохим. Он решает отправиться в путешествие по аркадным играм разных жанров, чтобы доказать всем, что и он тоже может быть героем. На своем пути Ральф встречает героев разных игр - хладнокровную сержанта Калхун из игры Hero’s Duty, оберегающую планету от нашествия инопланетных захватчиков, и сладкую на вид, но острую на язычок Сластену фон Дю, чье существование в гоночном симуляторе Sugar Rush внезапно оказывается под угрозой. Наконец-то Ральфу выпадает шанс показать, что он умеет не только разрушать!",
            2012,
            R.drawable.pstr_ralph
        ),
        Film(
            13,
            "Дюна",
            "Наследник знаменитого дома Атрейдесов Пол отправляется вместе с семьей на одну из самых опасных планет во Вселенной — Арракис. Здесь нет ничего, кроме песка, палящего солнца, гигантских чудовищ и основной причины межгалактических конфликтов — невероятно ценного ресурса, который называется меланж. В результате захвата власти Пол вынужден бежать и скрываться, и это становится началом его эпического путешествия. Враждебный мир Арракиса приготовил для него множество тяжелых испытаний, но только тот, кто готов взглянуть в глаза своему страху, достоин стать избранным.",
            2021,
            R.drawable.pstr_dune
        ),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        bindingMHSC = DataBindingUtil.inflate(inflater, R.layout.merge_home_screen_content, container, false)
        return bindingMHSC.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val scene = Scene.getSceneForLayout(binding.homeFragmentRoot, R.layout.merge_home_screen_content, requireContext())
        val searchSlide = Slide(Gravity.TOP).addTarget(R.id.search_view)
        val recyclerSlide = Slide(Gravity.BOTTOM).addTarget(R.id.recyclerView_films)
        val customTransition = TransitionSet().apply {
            duration = 500
            addTransition(recyclerSlide)
            addTransition(searchSlide)
        }
        TransitionManager.go(scene, customTransition)

        bindingMHSC.recyclerViewFilms.apply {
            filmsAdapter =
                FilmListRecyclerAdapter(object : FilmListRecyclerAdapter.OnItemClickListener {
                    override fun click(film: Film) {
                        (requireActivity() as MainActivity).launchDetailsFragment(film)
                    }
                })
            adapter = filmsAdapter
            val decorator = TopSpacingItemDecoration(1)
            addItemDecoration(decorator)
        }

        fun animationRVIn() = with(bindingMHSC) {
            val animInRV = AnimationUtils.loadLayoutAnimation(
                (requireContext() as MainActivity),
                R.anim.anim_layout
            )
            recyclerViewFilms.layoutAnimation = animInRV
            recyclerViewFilms.scheduleLayoutAnimation()
        }

        filmsAdapter.addItems(filmsDataBase)
        animationRVIn()

        bindingMHSC.searchView.setOnClickListener {
            bindingMHSC.searchView.isIconified = false
        }

        bindingMHSC.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText!!.isEmpty()) {
                    filmsAdapter.addItems(filmsDataBase)
                    return true
                }
                val result = filmsDataBase.filter {
                    it.title.toLowerCase(Locale.getDefault())
                        .contains(newText.toLowerCase(Locale.getDefault()))
                }
                filmsAdapter.addItems(result)
                return true
            }
        })
    }
}