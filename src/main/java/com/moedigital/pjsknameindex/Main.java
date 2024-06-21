package com.moedigital.pjsknameindex;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//public class SekaiIndex {
//
//    private static final List<String> fullNames = List.of("Hatsune Miku","Kagamine Rin","Kagamine Len","Megurine Luka","MEIKO","KAITO","Hoshino Ichika","Tenma Saki","Mochizuki Honami","Hinomori Shiho","Hanasato Minori","Kiritani Haruka","Momoi Airi","Hinomori Shizuku","Azusawa Kohane","Shiraishi An","Shinonome Akito","Aoyagi Toya","Tenma Tsukasa","Otori Emu","Kusanagi Nene","Kamishiro Rui","Yoisaki Kanade","Asahina Mafuyu","Shinonome Ena","Akiyama Mizuki");
//    private static final List<String> fullNamesCn = List.of("初音未来","镜音铃","镜音连","巡音流歌","MEIKO","KAITO","星乃一歌","天马咲希","望月穗波","日野森志步","花里实乃理","桐谷遥","桃井爱莉","日野森雫","小豆泽心羽","白石杏","东云彰人","青柳冬弥","天马司","凤笑梦","草薙宁宁","神代类","宵崎奏","朝比奈真冬","东云绘名","晓山瑞希");
//    private static final List<String> teamNames = List.of("VIRTUAL SINGER", "Leo/need", "MORE MORE JUMP!", "Vivid BAD SQUAD", "Wonderlands x Showtime", "Nightcord at 25:00");
//    private static final List<String> teamNamesCn = List.of("虚拟歌手", "Leo/need", "MORE MORE JUMP!", "Vivid BAD SQUAD", "Wonderlands x Showtime", "25时，在Nightcord。");
//    private static final List<String> teamNamesCnOfficial = List.of("虚拟歌手", "狮雨星绊", "萌萌飞跃少女团！", "炫狂小队", "奇幻仙境演出秀", "25点,夜音见");
//    private static final List<String> simpleNames = List.of("miku","rin","len","luka","meiko","kaito","ick","saki","hnm","shiho","mnr","hrk","airi","szk","khn","an","akt","toya","tks","emu","nene","rui","knd","mfy","ena","mzk");
//    private static final Map<String, List<String>> jokeNamesCn = new HashMap<>();
//
//    static {
//        jokeNamesCn.put("Hatsune Miku", List.of("葱", "猫葱", "白葱"));
//        jokeNamesCn.put("Kagamine Rin", List.of());
//        jokeNamesCn.put("Kagamine Len", List.of());
//        jokeNamesCn.put("Megurine Luka", List.of());
//        jokeNamesCn.put("MEIKO", List.of());
//        jokeNamesCn.put("KAITO", List.of());
//        jokeNamesCn.put("Hoshino Ichika", List.of());
//        jokeNamesCn.put("Tenma Saki", List.of("马晓希"));
//        jokeNamesCn.put("Mochizuki Honami", List.of("穗波妈妈"));
//        jokeNamesCn.put("Hinomori Shiho", List.of());
//        jokeNamesCn.put("Hanasato Minori", List.of());
//        jokeNamesCn.put("Kiritani Haruka", List.of());
//        jokeNamesCn.put("Momoi Airi", List.of());
//        jokeNamesCn.put("Hinomori Shizuku", List.of());
//        jokeNamesCn.put("Azusawa Kohane", List.of());
//        jokeNamesCn.put("Shiraishi An", List.of());
//        jokeNamesCn.put("Shinonome Akito", List.of());
//        jokeNamesCn.put("Aoyagi Toya", List.of());
//        jokeNamesCn.put("Tenma Tsukasa", List.of());
//        jokeNamesCn.put("Otori Emu", List.of("汪大吼"));
//        jokeNamesCn.put("Kusanagi Nene", List.of());
//        jokeNamesCn.put("Kamishiro Rui", List.of());
//        jokeNamesCn.put("Yoisaki Kanade", List.of("小气走"));
//        jokeNamesCn.put("Asahina Mafuyu", List.of("马福友"));
//        jokeNamesCn.put("Shinonome Ena", List.of("董慧敏"));
//        jokeNamesCn.put("Akiyama Mizuki", List.of());
//        // 其他戏称在这里添加
//    }
//
//    public static IndexResult sekaiIndex(String name, String type) {
//        List<Member> individualMembers = fullNames.stream().map(fullName -> {
//            int index = fullNames.indexOf(fullName);
//            return new Member(fullName, fullNamesCn.get(index), simpleNames.get(index), jokeNamesCn.getOrDefault(fullName, new ArrayList<>()));
//        }).collect(Collectors.toList());
//
//        List<Team> teams = teamNames.stream().map(teamName -> {
//            int index = teamNames.indexOf(teamName);
//            return new Team(teamName, teamNamesCn.get(index), teamNamesCnOfficial.get(index));
//        }).collect(Collectors.toList());
//
//        IndexResult indexResult = new IndexResult(teams, individualMembers);
//
//        if ("team".equalsIgnoreCase(type)) {
//            return indexResult.getTeams().stream().filter(team -> team.contains(name)).findFirst().orElse(null);
//        } else if ("individual".equalsIgnoreCase(type)) {
//            return indexResult.getIndividualMembers().stream().filter(member -> member.contains(name)).findFirst().orElse(null);
//        }
//
//        return null;
//    }
//
//    public static class IndexResult {
//        private final List<Team> teams;
//        private final List<Member> individualMembers;
//
//        public IndexResult(List<Team> teams, List<Member> individualMembers) {
//            this.teams = teams;
//            this.individualMembers = individualMembers;
//        }
//
//        public List<Team> getTeams() {
//            return teams;
//        }
//
//        public List<Member> getIndividualMembers() {
//            return individualMembers;
//        }
//    }
//
//    public static class Team {
//        private final String fullName;
//        private final String fullNameCn;
//        private final String fullNameCnOfficial;
//
//        public Team(String fullName, String fullNameCn, String fullNameCnOfficial) {
//            this.fullName = fullName;
//            this.fullNameCn = fullNameCn;
//            this.fullNameCnOfficial = fullNameCnOfficial;
//        }
//
//        public boolean contains(String name) {
//            return fullName.toLowerCase().contains(name.toLowerCase()) ||
//                    fullNameCn.toLowerCase().contains(name.toLowerCase()) ||
//                    fullNameCnOfficial.toLowerCase().contains(name.toLowerCase());
//        }
//    }
//
//    public static class Member {
//        private final String fullName;
//        private final String fullNameCn;
//        private final String simpleName;
//        private final List<String> jokeNamesCn;
//
//        public Member(String fullName, String fullNameCn, String simpleName, List<String> jokeNamesCn) {
//            this.fullName = fullName;
//            this.fullNameCn = fullNameCn;
//            this.simpleName = simpleName;
//            this.jokeNamesCn = jokeNamesCn;
//        }
//
//        public boolean contains(String name) {
//            return fullName.toLowerCase().contains(name.toLowerCase()) ||
//                    fullNameCn.toLowerCase().contains(name.toLowerCase()) ||
//                    simpleName.toLowerCase().contains(name.toLowerCase()) ||
//                    jokeNamesCn.stream().anyMatch(jokeName -> jokeName.toLowerCase().contains(name.toLowerCase()));
//        }
//    }
//}
