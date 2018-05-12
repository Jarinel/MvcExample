package com.jarinel;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<String> data = new ArrayList<>();
    private int index = 0;

    public Model() {
        data.add("HK416 — немецкая штурмовая винтовка, адаптированная под американскую модульную систему AR15, созданная фирмой Heckler & Koch. Несмотря на внешнее сходство с карабином M4, механизм винтовки на самом деле ближе к немецкой Н&К G36, а не к AR-образцам американских винтовок. Первоначально новое оружие должно было стать сменным модулем для установки на любую нижнюю часть ствольной коробки от карабина M4 или M16, однако позже появились и полнокомплектные автоматы. Название HK416 означает совместимость по стандартам NATO с магазинами от M4 и M16 - NATO-STANAG-DRAFT 4179 (M4/M16 Magazines) . Последний вариант автомата назван HK416A5. Кроме того поставляется версия под патрон 7,62х51мм - HK417 которая конкурирует с FN SCAR-H. Принята на вооружение бундесвера под обозначением семейства G38.");
        data.add("HK417 — автоматическая винтовка калибра 7,62 мм, созданная на основе HK416 (5,56 мм).");
        data.add("АК-12 — автомат Калашникова образца 2012 года, разработка концерна «Калашников».");
        data.add("AR-15 — американская полуавтоматическая винтовка под патрон 5,56×45 мм. Выпускается с 1963 года, поступает в продажу в качестве гражданского оружия для самообороны, охоты и т.п., является штатным оружием полиции.\n" +
                "\n" +
                "Была разработана компанией ArmaLite на основе AR-10 в качестве перспективной штурмовой винтовки для армии США. Изготовлена с применением алюминиевых сплавов и пластика. В 1959 году из-за финансовых трудностей ArmaLite продала права на конструкцию компании Colt’s Manufacturing Company. В начале 1960-х годов автоматический вариант AR-15 был принят на вооружение ВВС США под индексом M16, позже винтовку приняли на вооружение ВМС, а затем Армия США, с тех пор оригинальный заводской индекс AR-15 использовался для гражданских и полицейских модификаций военной винтовки.\n" +
                "\n" +
                "В период после 1963 года товарный знак AR-15 принадлежит компании Colt’s Manufacturing Company и относится исключительно к самозарядным винтовкам. Вариации AR-15 изготовляются и другими производителями, но под другими торговыми марками.");
    }

    public void addData(String text) {
        data.add(text);
    }

    public void prev() {
        index = index - 1 < 0 ? data.size() - 1 : index - 1;
    }

    public void next() {
        index = index + 1 >= data.size() ? 0 : index + 1;
    }

    public void last() {
        index = data.size() - 1;
    }

    public String getCurrentData() {
        return data.get(index);
    }

    public void save(String text) {
        data.set(index, text);
    }
}
