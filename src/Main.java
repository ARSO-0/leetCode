import java.io.*;

public class Main {


//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new FileReader("./input.txt"));
//        int orderCount = Integer.parseInt(bufferedReader.readLine());
//        Order[] orders = new Order[orderCount];
//        for(int i = 0; i < orderCount; ++i){
//            orders[i] = new Order(bufferedReader.readLine());
//        }
//
//        int requestCount = Integer.parseInt(bufferedReader.readLine());
//        Request[] requests = new Request[requestCount];
//        for(int i = 0; i < requestCount; ++i){
//            requests[i] = new Request(bufferedReader.readLine());
//        }
//
//        StringBuilder result = new StringBuilder();
//        for(Request request : requests){
//            int sumPrice = 0;
//            int sumDuration = 0;
//            for(Order order : orders){
//                if(request.type == 1 && request.start <= order.start && request.end >= order.start){
//                    sumPrice += order.cost;
//                }
//                if(request.type == 2 && request.start <= order.end && request.end >= order.end){
//                    sumDuration += order.end - order.start;
//                }
//            }
//            if(request.type == 1){
//                result.append(sumPrice).append(" ");
//            } else {
//                result.append(sumDuration).append(" ");
//            }
//            int sumPrice = 0;
//            int sumDuration = 0;
//            if(request.type == 1){
//                for(Order order : orders) {
//                    if(request.start <= order.start && request.end >= order.start){
//                            sumPrice += order.cost;
//                    }
//                }
//                result.append(sumPrice).append(" ");
//            } else {
//                for(Order order : orders) {
//                    if(request.start <= order.end && request.end >= order.end){
//                        sumDuration += order.end - order.start;
//                    }
//                }
//                result.append(sumDuration).append(" ");
//            }
//        }
//        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("./output.txt"))){
//            bufferedWriter.write(String.valueOf(result));
//        }
//    }

    public static class Order{
        private int start;
        private int end;
        private int cost;

        public Order(String params) {
            String[] param = params.split(" ");
            this.start = Integer.parseInt(param[0]);
            this.end = Integer.parseInt(param[1]);
            this.cost = Integer.parseInt(param[2]);
        }
    }

    public static class Request{
        private int start;
        private int end;
        private int type;

        public Request(String params) {
            String[] param = params.split(" ");
            this.start = Integer.parseInt(param[0]);
            this.end = Integer.parseInt(param[1]);
            this.type = Integer.parseInt(param[2]);
        }
    }

//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new FileReader("./input.txt"));
//        int recordCount = Integer.parseInt(bufferedReader.readLine());
//        ArrayList<Record> records = new ArrayList<>();
//        for(int i = 0; i < recordCount; ++i){
//            Scanner scanner = new Scanner(bufferedReader.readLine());
//            records.add(new Record(scanner));
//        }
//        Set<Integer> rocketIds = new HashSet<>();
//        for(Record record : records){
//            rocketIds.add(record.id);
//        }
//        records.sort(Comparator.comparing(Record::getMinutes));
//
//        ExecutorService executor = Executors.newFixedThreadPool(rocketIds.size());
//        ArrayList<Future<Rocket>> resultRockets = new ArrayList<>();
//        for(int id : rocketIds){
//            ArrayList<Record> rocketRecords = new ArrayList<>();
//            for(Record record : records){
//                if(record.id == id){
//                    rocketRecords.add(record);
//                }
//            }
//            resultRockets.add(executor.submit(new RecordWorker(rocketRecords)));
//        }
//
//        ArrayList<Rocket> rockets = new ArrayList<>();
//        resultRockets.forEach(r -> {
//            try {
//                rockets.add(r.get());
//            } catch (InterruptedException | ExecutionException e) {
//                e.printStackTrace();
//            }
//        });
//        executor.shutdown();
//        rockets.sort(Comparator.comparing(Rocket::getId));
//        StringBuilder result = new StringBuilder();
//        rockets.forEach(r -> result.append(r.workTime).append(" "));
//
//        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("./output.txt"))){
//            bufferedWriter.write(String.valueOf(result));
//        }
//    }
//
//    public static class Record{
//        private Integer minutes;
//        private Integer id;
//        private Character status;
//
//        public Record(Scanner scanner) {
//            this.minutes = scanner.nextInt() * 24 * 60 + scanner.nextInt() * 60 + scanner.nextInt();
//            this.id = scanner.nextInt();
//            this.status = scanner.next().charAt(0);
//        }
//
//        public Integer getMinutes() {
//            return minutes;
//        }
//    }
//
//    public static class Rocket{
//        private final int id;
//        private int workTime;
//
//        public Rocket(int id) {
//            this.id = id;
//            this.workTime = 0;
//        }
//
//        public int getId() {
//            return id;
//        }
//    }
//
//    public static class RecordWorker implements Callable<Rocket> {
//
//        private final ArrayList<Record> records;
//
//        public RecordWorker(ArrayList<Record> records) {
//            this.records = records;
//        }
//
//        @Override
//        public Rocket call() throws Exception {
//            Rocket rocket = new Rocket(records.get(0).id);
//            int id = records.get(0).id;
//            int eventTime = 0;
//            int eventStartTime = 0;
//            for(Record record : records){
//                if (record.status != 'A') {
//                    eventTime = record.minutes - eventStartTime;
//                    rocket.workTime += eventTime;
//                }
//                eventStartTime = record.minutes;
//            }
//            return rocket;
//        }
//    }

//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new FileReader("./input.txt"));
//        int userCount = Integer.parseInt(bufferedReader.readLine());
//        ArrayList<User> users = new ArrayList<>();
//        for(int i = 0; i < userCount; ++i){
//            Scanner scanner = new Scanner(bufferedReader.readLine());
//            users.add(new User(scanner));
//        }
//
//        StringBuilder result = new StringBuilder();
//        for(User user : users){
//            // 1 FIO distinct letter count
//            Set<Character> charSet = new HashSet<>();
//            StringBuilder nameString = new StringBuilder();
//            nameString.append(user.firstName).append(user.secondName).append(user.thirdName);
//            for(int i = 0; i < nameString.length(); ++i){
//                charSet.add(nameString.charAt(i));
//            }
//            int distinctLetterCount = charSet.size();
//            int dayMonthDigitsSum = 0;
//            StringBuilder str = new StringBuilder();
//            str.append(user.day).append(user.month);
//            for(int i = 0; i < str.length(); ++i){
//                dayMonthDigitsSum += Integer.parseInt(String.valueOf(str.charAt(i)));
//            }
//
//            char firstLetter = Character.toLowerCase(user.secondName.charAt(0));
//
//            int alphabeticPosition = (int) firstLetter - 96;
//
//            long code = distinctLetterCount + dayMonthDigitsSum * 64L + alphabeticPosition * 256;
//            String hexCode = Long.toHexString(code);
//            hexCode = hexCode.toUpperCase();
//            for(int i = hexCode.length() - 3; i < hexCode.length(); ++i){
//                result.append(hexCode.charAt(i));
//            }
//            result.append(" ");
//        }
//        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("./output.txt"))){
//            bufferedWriter.write(String.valueOf(result));
//        }
//    }
//
//    public static class User{
//        private String firstName;
//        private String secondName;
//        private String thirdName;
//        private int day;
//        private int month;
//        private int year;
//
//        public User(Scanner scanner) {
//            String[] splitStrings = scanner.next().split(",");
//            this.secondName = splitStrings[0];
//            this.firstName = splitStrings[1];
//            this.thirdName  = splitStrings[2];
//            this.day = Integer.parseInt(splitStrings[3]);
//            this.month = Integer.parseInt(splitStrings[4]);
//            this.year = Integer.parseInt(splitStrings[5]);
//        }
//    }

//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new FileReader("./input.txt"));
//        Scanner scanner = new Scanner(bufferedReader.readLine());
//        int n = scanner.nextInt();
//        int k = scanner.nextInt();
//        scanner = new Scanner(bufferedReader.readLine());
//        int[] arr = new int[n];
//        for(int i = 0; i < n; ++i){
//            arr[i] = scanner.nextInt();
//        }
//        bufferedReader.close();
//        FileWriter fwOb = new FileWriter("./output.txt", false);
//        PrintWriter pwOb = new PrintWriter(fwOb, false);
//        pwOb.flush();
//        pwOb.close();
//        fwOb.close();
//
//        StringBuilder sb = new StringBuilder();
//        for(int i = 0; i < n; i++){
//            int[] temp = new int[k];
//            int index = 0;
//            int lastIndex = 0;
//            for(int j = 0; j < n; j++){
//                if(index == k){
//                    lastIndex = j;
//                    break;
//                }
//                if(i != j){
//                    temp[index] = Math.abs(arr[i] - arr[j]);
//                    index++;
//                }
//            }
//            for(int m = lastIndex; m < n; m++){
//                if(m != i){
//                    int dist = Math.abs(arr[i] - arr[m]);
//                    int max = Arrays.stream(temp).max().orElse(-1);
//                    if(dist < max){
//                        for(int l = 0; l < k; l++){
//                            if(temp[l] == max){
//                                temp[l] = dist;
//                                break;
//                            }
//                        }
//                    }
//                }
//            }
//            sb.append(Arrays.stream(temp).sum()).append(" ");
//        }
//        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("./output.txt"))){
//            bufferedWriter.write(sb.toString());
//        }
//    }

//    public static void solve(Plane plane, int groupCount, Group[] groups) {
//        for(int i = 0; i < groupCount; ++i){
//            try {
//                plane.fitGroup(groups[i]);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader bufferedReader = new BufferedReader(new FileReader("./input.txt"));
//        Plane plane = new Plane(Integer.parseInt(bufferedReader.readLine()));
//        for(int i = 0; i < plane.rowCount; ++i){
//            String data = bufferedReader.readLine();
//            plane.fillRow(i, data);
//        }
//
//        int groupCount = Integer.parseInt(bufferedReader.readLine());
//        Group[] groups = new Group[groupCount];
//        for(int i = 0; i < groupCount; ++i){
//            groups[i] = new Group(bufferedReader.readLine());
//        }
//        bufferedReader.close();
//
//        FileWriter fwOb = new FileWriter("./output.txt", false);
//        PrintWriter pwOb = new PrintWriter(fwOb, false);
//        pwOb.flush();
//        pwOb.close();
//        fwOb.close();
//
//        solve(plane, groupCount, groups);
//    }
//
//    public static class Plane {
//        private final int rowCount;
//        private final Row[] rows;
//
//        public Plane(int rowCount) {
//            this.rowCount = rowCount;
//            this.rows = new Row[rowCount];
//        }
//
//        public void fillRow(int rowIndex, String rowData){
//            Row newRow = new Row();
//
//            for(int i = 0; i < rowData.length(); ++i){
//                if(i < 3){
//                    if(rowData.charAt(i) == '.'){
//                        newRow.leftSeats[i] = 1;
//                    } else {
//                        newRow.leftSeats[i] = 0;
//                    }
//                }
//                if(i > 3){
//                    if(rowData.charAt(i) == '.'){
//                        newRow.rightSeats[i - 4] = 1;
//                    } else {
//                        newRow.rightSeats[i - 4] = 0;
//                    }
//                }
//            }
//            rows[rowIndex] = newRow;
//        }
//
//        public void fitGroup(Group group) throws IOException {
//            //System.out.println(group);
//            boolean canFit = false;
//            StringBuilder seats = new StringBuilder();
//            for(int i = 0; i < rowCount; i++){
//                // есть достаточно мест с нужной стороны
//                if(Objects.equals(group.side, "left") && Arrays.stream(rows[i].leftSeats).sum() >= group.count){
//                    // если среднее место занято, группу из двух человек не посадить
//                    if(group.count == 2 && rows[i].leftSeats[1] == 0){
//                        continue;
//                    }
//                    // есть свобдное место с требуемой позицией
//                    if(Objects.equals(group.position, "aisle") && rows[i].leftSeats[2]==1){
//                        canFit = true;
//                        int pos = 2;
//                        for(int j = 0; j < group.count; j++){
//                            rows[i].leftSeats[pos] = -1;
//                            pos--;
//                        }
//                        switch (group.count){
//                            case 1 -> seats.append(i+1).append("C");
//                            case 2 -> seats.append(i+1).append("B").append(" ").append(i+1).append("C");
//                            case 3 -> seats.append(i+1).append("A").append(" ").append(i+1).append("B").append(" ").append(i+1).append("C");
//                        }
//                        break;
//                    }
//                    if(Objects.equals(group.position, "window") && rows[i].leftSeats[0]==1){
//                        canFit = true;
//                        int pos = 0;
//                        for(int j = 0; j < group.count; j++){
//                            rows[i].leftSeats[pos] = -1;
//                            pos++;
//                        }
//                        switch (group.count){
//                            case 1 -> seats.append(i+1).append("A");
//                            case 2 -> seats.append(i+1).append("A").append(" ").append(i+1).append("B");
//                            case 3 -> seats.append(i+1).append("A").append(" ").append(i+1).append("B").append(" ").append(i+1).append("C");
//                        }
//                        break;
//                    }
//                }
//
//                if(Objects.equals(group.side, "right") && Arrays.stream(rows[i].rightSeats).sum() >= group.count){
//                    // если среднее место занято, группу из двух человек не посадить
//                    if(group.count == 2 && rows[i].rightSeats[1] == 0){
//                        continue;
//                    }
//                    // есть свобдное место с требуемой позицией
//                    if(Objects.equals(group.position, "aisle") && rows[i].rightSeats[0]==1){
//                        canFit = true;
//                        int pos = 0;
//                        for(int j = 0; j < group.count; j++){
//                            rows[i].rightSeats[pos] = -1;
//                            pos++;
//                        }
//                        switch (group.count){
//                            case 1 -> seats.append(i+1).append("D");
//                            case 2 -> seats.append(i+1).append("D").append(" ").append(i+1).append("E");
//                            case 3 -> seats.append(i+1).append("D").append(" ").append(i+1).append("E").append(" ").append(i+1).append("F");
//                        }
//                        break;
//                    }
//                    if(Objects.equals(group.position, "window") && rows[i].rightSeats[2]==1){
//                        canFit = true;
//                        int pos = 2;
//                        for(int j = 0; j < group.count; j++){
//                            rows[i].rightSeats[pos] = -1;
//                            pos--;
//                        }
//                        switch (group.count){
//                            case 1 -> seats.append(i+1).append("F");
//                            case 2 -> seats.append(i+1).append("E").append(" ").append(i+1).append("F");
//                            case 3 -> seats.append(i+1).append("D").append(" ").append(i+1).append("E").append(" ").append(i+1).append("F");
//                        }
//                        break;
//                    }
//                }
//
//            }
//            try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("./output.txt", true))){
//                if(!canFit){
//                    bufferedWriter.append("Cannot fulfill passengers requirements\n");
//                    return;
//                }
//                // после посадки выводим в файл сообщение
//                bufferedWriter.append("Passengers can take seats: ").append(String.valueOf(seats)).append("\n");
//                bufferedWriter.append(printPlaneView());
//                bufferedWriter.close();
//                refreshSeatsStatus();
//            }
//        }
//
//        private void refreshSeatsStatus() {
//            for(int i = 0 ; i < rowCount; i++){
//                for(int j = 0; j < rows[i].leftSeats.length; j++){
//                    if(rows[i].leftSeats[j] == -1){
//                        rows[i].leftSeats[j] = 0;
//                    }
//                }
//                for(int j = 0; j < rows[i].rightSeats.length; j++){
//                    if(rows[i].rightSeats[j] == -1){
//                        rows[i].rightSeats[j] = 0;
//                    }
//                }
//            }
//        }
//
//        private String printPlaneView() {
//            StringBuilder result = new StringBuilder();
//            for(int i = 0 ; i < rowCount; i++){
//                for(int j = 0; j < rows[i].leftSeats.length; j++){
//                    result.append(convertSymbols(rows[i].leftSeats[j]));
//                }
//                result.append("_");
//                for(int k = 0; k < rows[i].rightSeats.length; k++){
//                    result.append(convertSymbols(rows[i].rightSeats[k]));
//                }
//                result.append("\n");
//            }
//
//            return result.toString();
//        }
//
//        private char convertSymbols(int seat) {
//            return switch (seat) {
//                case -1 -> 'X';
//                case 0 -> '#';
//                case 1 -> '.';
//                default -> '!';
//            };
//        }
//    }
//
//    public static class Row {
//        public int[] leftSeats;
//        public int[] rightSeats;
//
//        public Row() {
//            leftSeats = new int[]{1, 1, 1};
//            rightSeats = new int[]{1, 1, 1};
//        }
//    }
//
//    public static class Group {
//        public int count;
//        public String side;
//        public String position;
//
//        public Group(String data) {
//            Scanner scanner = new Scanner(data);
//            this.count = scanner.nextInt();
//            this.side = scanner.next();
//            this.position = scanner.next();
//        }
//    }




//    public static int solve(int count, int[] levels){
//        // массив должен быть неубывающим, любой неубывающий массив имеет решение
//        for(int i = 1; i < levels.length; ++i){
//            if(levels[i] < levels[i - 1]){
//                return -1;
//            }
//        }
//
//        // количество операций для зполнения будет равно разности уровня между самым заполненным и самым пустым резервуарами
//        int maxLevel = Arrays.stream(levels).max().orElse(0);
//        int minLevel = Arrays.stream(levels).min().orElse(0);
//        return maxLevel - minLevel;
//    }
//
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader bufferedReader = new BufferedReader(new FileReader("./input.txt"));
//        int reservoirCount = Integer.parseInt(bufferedReader.readLine());
//        int[] reservoirLevel = new int[reservoirCount];
//        Scanner values = new Scanner(bufferedReader.readLine());
//        bufferedReader.close();
//
//        int i = 0;
//        while (values.hasNext()){
//            reservoirLevel[i] = values.nextInt();
//            i++;
//        }
//        System.out.println(solve(reservoirCount, reservoirLevel));
//    }

}

