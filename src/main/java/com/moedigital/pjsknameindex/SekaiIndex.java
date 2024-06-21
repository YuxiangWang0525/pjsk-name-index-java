package com.moedigital.pjsknameindex;

import java.util.*;

public class SekaiIndex {

    public static final List<String> fullName = Arrays.asList("Hatsune Miku", "Kagamine Rin", "Kagamine Len", "Megurine Luka", "MEIKO", "KAITO", "Hoshino Ichika", "Tenma Saki", "Mochizuki Honami", "Hinomori Shiho", "Hanasato Minori", "Kiritani Haruka", "Momoi Airi", "Hinomori Shizuku", "Azusawa Kohane", "Shiraishi An", "Shinonome Akito", "Aoyagi Toya", "Tenma Tsukasa", "Otori Emu", "Kusanagi Nene", "Kamishiro Rui", "Yoisaki Kanade", "Asahina Mafuyu", "Shinonome Ena", "Akiyama Mizuki");
    public static final List<String> fullNameCn = Arrays.asList("初音未来", "镜音铃", "镜音连", "巡音流歌", "MEIKO", "KAITO", "星乃一歌", "天马咲希", "望月穗波", "日野森志步", "花里实乃理", "桐谷遥", "桃井爱莉", "日野森雫", "小豆泽心羽", "白石杏", "东云彰人", "青柳冬弥", "天马司", "凤笑梦", "草薙宁宁", "神代类", "宵崎奏", "朝比奈真冬", "东云绘名", "晓山瑞希");

    public static final List<String> teamName = Arrays.asList("VIRTUAL SINGER", "Leo/need", "MORE MORE JUMP!", "Vivid BAD SQUAD", "Wonderlands x Showtime", "Nightcord at 25:00");
    public static final List<String> teamNameCn = Arrays.asList("虚拟歌手", "Leo/need", "MORE MORE JUMP!", "Vivid BAD SQUAD", "Wonderlands x Showtime", "25时，在Nightcord。");
    public static final List<String> teamNameCnOfficial = Arrays.asList("虚拟歌手", "狮雨星绊", "萌萌飞跃少女团！", "炫狂小队", "奇幻仙境演出秀", "25点,夜音见");

    public static final List<String> simpleName = Arrays.asList("miku", "rin", "len", "luka", "meiko", "kaito", "ick", "saki", "hnm", "shiho", "mnr", "hrk", "airi", "szk", "khn", "an", "akt", "toya", "tks", "emu", "nene", "rui", "knd", "mfy", "ena", "mzk");
    public static final List<String> simpleTeamName = Arrays.asList("vs", "ln", "mmj", "vbs", "ws", "25时");

    public static final Map<String, List<String>> jokeNameCn = new HashMap<String, List<String>>() {{
        put("Hatsune Miku", Arrays.asList("葱", "猫葱", "白葱"));
        put("Kagamine Rin", Collections.emptyList());
        put("Kagamine Len", Collections.emptyList());
        put("Megurine Luka", Collections.emptyList());
        put("MEIKO", Collections.emptyList());
        put("KAITO", Collections.emptyList());
        put("Hoshino Ichika", Collections.emptyList());
        put("Tenma Saki", Arrays.asList("马晓希"));
        put("Mochizuki Honami", Arrays.asList("穗波妈妈"));
        put("Hinomori Shiho", Collections.emptyList());
        put("Hanasato Minori", Collections.emptyList());
        put("Kiritani Haruka", Collections.emptyList());
        put("Momoi Airi", Collections.emptyList());
        put("Hinomori Shizuku", Collections.emptyList());
        put("Azusawa Kohane", Collections.emptyList());
        put("Shiraishi An", Collections.emptyList());
        put("Shinonome Akito", Collections.emptyList());
        put("Aoyagi Toya", Collections.emptyList());
        put("Tenma Tsukasa", Collections.emptyList());
        put("Otori Emu", Arrays.asList("汪大吼"));
        put("Kusanagi Nene", Collections.emptyList());
        put("Kamishiro Rui", Collections.emptyList());
        put("Yoisaki Kanade", Arrays.asList("小气走"));
        put("Asahina Mafuyu", Arrays.asList("马福友"));
        put("Shinonome Ena", Arrays.asList("董慧敏"));
        put("Akiyama Mizuki", Collections.emptyList());
    }};

    public static final Map<String, String> characterIndex = new HashMap<>();
    public static final Map<String, String> teamIndex = new HashMap<>();
    public static final Map<String, String> teamCnOfficialIndex = new HashMap<>();
    public static final Map<String, String> teamCnIndex = new HashMap<>();

    static {
        for (int i = 0; i < simpleName.size(); i++) {
            characterIndex.put(simpleName.get(i), fullNameCn.get(i));
        }

        for (int i = 0; i < simpleTeamName.size(); i++) {
            teamIndex.put(simpleTeamName.get(i), teamNameCn.get(i));
        }

        for (int i = 0; i < teamNameCnOfficial.size(); i++) {
            teamCnOfficialIndex.put(teamNameCnOfficial.get(i), teamNameCn.get(i));
        }

        for (int i = 0; i < teamNameCn.size(); i++) {
            teamCnIndex.put(teamNameCn.get(i), teamNameCnOfficial.get(i));
        }
    }

    public static Map<? extends Object,? extends Object> indexer(String name, String type) {
        Map<String, Object> data = new HashMap<>();
        data.put("full_name", fullName);
        data.put("full_name_cn", fullNameCn);
        data.put("simple_name", simpleName);
        data.put("joke_name_cn", jokeNameCn);
        data.put("team_name", teamName);
        data.put("team_name_cn", teamNameCn);
        data.put("team_name_cn_official", teamNameCnOfficial);
        data.put("simple_team_name", simpleTeamName);

        Map<String, List<Map<String, String>>> index = createIndex(data);

        Map<String, String> result = null;
        if ("team".equals(type)) {
            result = index.get("teams").stream()
                    .filter(team -> team.values().stream()
                            .anyMatch(value -> value.toLowerCase().contains(name.toLowerCase())))
                    .findFirst()
                    .orElse(null);
        } else if ("individual".equals(type)) {
            result = index.get("individual").stream()
                    .filter(member -> member.values().stream()
                            .anyMatch(value -> value.toLowerCase().contains(name.toLowerCase())))
                    .findFirst()
                    .orElse(null);
        }

        return result == null ? Collections.emptyMap() : result;
    }

    private static Map<String, List<Map<String, String>>> createIndex(Map<String, Object> data) {
        Map<String, List<Map<String, String>>> groupedData = new HashMap<>();
        groupedData.put("teams", new ArrayList<>());
        groupedData.put("individual", new ArrayList<>());

        List<String> teamNames = (List<String>) data.get("team_name");
        List<String> teamNamesCn = (List<String>) data.get("team_name_cn");
        List<String> teamNamesCnOfficial = (List<String>) data.get("team_name_cn_official");
        List<String> simpleTeamNames = (List<String>) data.get("simple_team_name");

        for (int i = 0; i < teamNames.size(); i++) {
            Map<String, String> team = new HashMap<>();
            team.put("full_name", teamNames.get(i));
            team.put("full_name_cn", teamNamesCn.get(i));
            team.put("full_name_cn_official", teamNamesCnOfficial.get(i));
            team.put("simple_name", simpleTeamNames.get(i));
            groupedData.get("teams").add(team);
        }

        List<String> fullNames = (List<String>) data.get("full_name");
        List<String> fullNamesCn = (List<String>) data.get("full_name_cn");
        List<String> simpleNames = (List<String>) data.get("simple_name");
        Map<String, List<String>> jokeNamesCn = (Map<String, List<String>>) data.get("joke_name_cn");

        for (int i = 0; i < fullNames.size(); i++) {
            Map<String, String> member = new HashMap<>();
            member.put("full_name", fullNames.get(i));
            member.put("full_name_cn", fullNamesCn.get(i));
            member.put("simple_name", simpleNames.get(i));
            member.put("joke_name_cn", jokeNamesCn.get(fullNames.get(i)) != null ? String.join(",", jokeNamesCn.get(fullNames.get(i))) : "");
            groupedData.get("individual").add(member);
        }

        return groupedData;
    }
}


