# 数据库设计文档

**数据库名：** liuyu

**文档版本：** 1.0.0

**文档描述：** 数据库设计文档生成

| 表名                  | 说明       |
| :-------------------- | :--------- |
| [AlarmHuman](#AlarmHuman) |  |
| [CarEntity](#CarEntity) |  |
| [CaseMsg](#CaseMsg) |  |
| [Channel_Id](#Channel_Id) |  |
| [Device](#Device) |  |
| [Enterprise](#Enterprise) |  |
| [FaceEntity](#FaceEntity) |  |
| [JingQingSJDTest](#JingQingSJDTest) |  |
| [KqEntity](#KqEntity) |  |
| [LeaderDutyTable](#LeaderDutyTable) |  |
| [PoliceDetail](#PoliceDetail) |  |
| [PoliceLocation](#PoliceLocation) |  |
| [Sjd](#Sjd) |  |
| [SjdLocation](#SjdLocation) |  |
| [SuspectTask](#SuspectTask) |  |
| [clazz](#clazz) |  |
| [duty_table](#duty_table) |  |
| [hibernate_sequence](#hibernate_sequence) |  |
| [hibernate_sequences](#hibernate_sequences) |  |
| [jpa_test](#jpa_test) |  |
| [phone](#phone) |  |
| [student](#student) |  |
| [student_entity](#student_entity) |  |
| [studententity](#studententity) |  |
| [test](#test) |  |
| [weather_entity](#weather_entity) |  |

**表名：** <a id="AlarmHuman">AlarmHuman</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :--: | :--- | :------: | :----: | :----: | :------: | :--: | :----: | :--: |
|  1   | id |   intunsigned   | 10 |   0    |    N     |  Y   |       |   |
|  2   | name |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  3   | identify |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  4   | camera_id |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  5   | camera_name |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  6   | alarm_time |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  7   | photo |   varchar   | 255 |   0    |    Y     |  N   |       |   |

**表名：** <a id="CarEntity">CarEntity</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :--: | :--- | :------: | :----: | :----: | :------: | :--: | :----: | :--: |
|  1   | id |   varchar   | 255 |   0    |    N     |  Y   |       |   |
|  2   | time |   bigint   | 19 |   0    |    Y     |  N   |       |   |
|  3   | shot_time |   bigint   | 19 |   0    |    Y     |  N   |       |   |
|  4   | source_id |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  5   | info_type |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  6   | unit_id |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  7   | standard_id |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  8   | unit_name |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  9   | carnumber |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  10   | plate_type |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  11   | image_url |   varchar   | 512 |   0    |    Y     |  N   |       |   |
|  12   | lat |   double   | 15 |   12    |    Y     |  N   |       |   |
|  13   | lon |   double   | 15 |   12    |    Y     |  N   |       |   |
|  14   | provider |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  15   | category |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  16   | district_code |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  17   | policeStation_code |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  18   | plate_color |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  19   | vehicle_color |   varchar   | 255 |   0    |    Y     |  N   |       |   |

**表名：** <a id="CaseMsg">CaseMsg</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :--: | :--- | :------: | :----: | :----: | :------: | :--: | :----: | :--: |
|  1   | id |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  2   | isdel |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  3   | dataversion |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  4   | lrr_sfzh |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  5   | lrsj |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  6   | xgr_sfzh |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  7   | xgsj |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  8   | jqbh |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  9   | bjsj |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  10   | bjfs |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  11   | bjrxm |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  12   | bjrxb |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  13   | bjrlxdh |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  14   | bjrgzdw |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  15   | bjrzz |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  16   | bjlb |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  17   | bjnr |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  18   | afsj |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  19   | afdd |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  20   | gxdwbh |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  21   | gxdwmc |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  22   | cjnr |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  23   | cjr_sfzh |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  24   | cjr_xm |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  25   | cjdw |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  26   | cbqy_bh |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  27   | djsj |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  28   | jjgmfnrs |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  29   | jjgmetrs |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  30   | jxpwrs |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  31   | jlrc |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  32   | jdcc |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  33   | czcc |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  34   | fssjsx |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  35   | fssjxx |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  36   | sfjtbl |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  37   | fzry |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  38   | tfrs |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  39   | bjsymc |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  40   | fsqymc |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  41   | fsqy |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  42   | fsddmc |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  43   | fsdd |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  44   | cjsymc |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  45   | zpdwmc |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  46   | zpdwbh |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  47   | bjlx |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  48   | bjtj |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  49   | is_assign |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  50   | sfwjry |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  51   | dwd_loadtime |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  52   | dwd_updatetime |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  53   | dwd_yxbz |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  54   | dt |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  55   | zabmc1 |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  56   | lrsj_1 |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  57   | lrsj_dt |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  58   | pcsjc |   varchar   | 255 |   0    |    Y     |  N   |       |   |

**表名：** <a id="Channel_Id">Channel_Id</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :--: | :--- | :------: | :----: | :----: | :------: | :--: | :----: | :--: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       |   |
|  2   | model_id |   varchar   | 255 |   0    |    N     |  N   |       |   |
|  3   | channel_id |   varchar   | 255 |   0    |    N     |  N   |       |   |

**表名：** <a id="Device">Device</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :--: | :--- | :------: | :----: | :----: | :------: | :--: | :----: | :--: |
|  1   | id |   intunsigned   | 10 |   0    |    N     |  Y   |       |   |
|  2   | camera_id |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  3   | camera_name |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  4   | ip |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  5   | jd |   double   | 15 |   12    |    Y     |  N   |       |   |
|  6   | wd |   double   | 15 |   13    |    Y     |  N   |       |   |

**表名：** <a id="Enterprise">Enterprise</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :--: | :--- | :------: | :----: | :----: | :------: | :--: | :----: | :--: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       |   |
|  2   | name |   varchar   | 255 |   0    |    N     |  N   |       | 企业名称  |
|  3   | jurisdiction |   varchar   | 255 |   0    |    N     |  N   |       | 所属辖区  |
|  4   | address |   varchar   | 255 |   0    |    N     |  N   |       | 地址  |
|  5   | phone |   varchar   | 255 |   0    |    N     |  N   |       | 电话  |
|  6   | police |   varchar   | 255 |   0    |    Y     |  N   |       | 警员姓名  |
|  7   | new_address |   varchar   | 255 |   0    |    N     |  N   |       | 新地址  |
|  8   | jd |   double   | 15 |   12    |    N     |  N   |       | 经度  |
|  9   | wd |   double   | 14 |   11    |    N     |  N   |       | 纬度  |

**表名：** <a id="FaceEntity">FaceEntity</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :--: | :--- | :------: | :----: | :----: | :------: | :--: | :----: | :--: |
|  1   | id |   varchar   | 64 |   0    |    N     |  Y   |       |   |
|  2   | time |   bigint   | 19 |   0    |    Y     |  N   |       |   |
|  3   | shot_time |   bigint   | 19 |   0    |    Y     |  N   |       |   |
|  4   | source_id |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  5   | faceIdent_id |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  6   | info_type |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  7   | unit_id |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  8   | standard_id |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  9   | unit_name |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  10   | image_url |   varchar   | 512 |   0    |    Y     |  N   |       |   |
|  11   | scene_url |   varchar   | 512 |   0    |    Y     |  N   |       |   |
|  12   | similarity |   double   | 15 |   12    |    Y     |  N   |       |   |
|  13   | lat |   double   | 15 |   12    |    Y     |  N   |       |   |
|  14   | lon |   double   | 15 |   12    |    Y     |  N   |       |   |
|  15   | provider |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  16   | category |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  17   | district_code |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  18   | policeStation_code |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  19   | place_code |   varchar   | 255 |   0    |    Y     |  N   |       |   |

**表名：** <a id="JingQingSJDTest">JingQingSJDTest</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :--: | :--- | :------: | :----: | :----: | :------: | :--: | :----: | :--: |
|  1   | sjdbh |   varchar   | 255 |   0    |    N     |  Y   |       |   |
|  2   | zxqh |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  3   | cllx |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  4   | jjkssj |   bigint   | 19 |   0    |    Y     |  N   |       |   |
|  5   | jjdw |   varchar   | 50 |   0    |    Y     |  N   |       |   |
|  6   | jjygh |   varchar   | 50 |   0    |    Y     |  N   |       |   |
|  7   | jjyxm |   varchar   | 50 |   0    |    Y     |  N   |       |   |
|  8   | bjr |   varchar   | 50 |   0    |    Y     |  N   |       |   |
|  9   | lxdh |   varchar   | 55 |   0    |    Y     |  N   |       |   |
|  10   | sfdz |   varchar   | 1200 |   0    |    Y     |  N   |       |   |
|  11   | x |   varchar   | 80 |   0    |    Y     |  N   |       |   |
|  12   | y |   varchar   | 80 |   0    |    Y     |  N   |       |   |
|  13   | jqjb |   varchar   | 55 |   0    |    Y     |  N   |       |   |
|  14   | bjnr |   varchar   | 4000 |   0    |    Y     |  N   |       |   |
|  15   | slzt |   varchar   | 20 |   0    |    Y     |  N   |       |   |
|  16   | aymc |   varchar   | 55 |   0    |    Y     |  N   |       |   |
|  17   | jqlbmc |   varchar   | 55 |   0    |    Y     |  N   |       |   |
|  18   | jqlxmc |   varchar   | 55 |   0    |    Y     |  N   |       |   |
|  19   | update_time |   timestamp   | 19 |   0    |    Y     |  N   |   CURRENT_TIMESTAMP    |   |
|  20   | date |   date   | 10 |   0    |    N     |  N   |       |   |
|  21   | upgrade |   char   | 3 |   0    |    Y     |  N   |       |   |
|  22   | scfkr |   varchar   | 30 |   0    |    Y     |  N   |       |   |
|  23   | attention |   char   | 3 |   0    |    Y     |  N   |       |   |
|  24   | scfknr |   varchar   | 500 |   0    |    Y     |  N   |       |   |

**表名：** <a id="KqEntity">KqEntity</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :--: | :--- | :------: | :----: | :----: | :------: | :--: | :----: | :--: |
|  1   | dwd_zjid |   varchar   | 64 |   0    |    N     |  Y   |       |   |
|  2   | xm |   varchar   | 20 |   0    |    Y     |  N   |       |   |
|  3   | zjlx |   varchar   | 55 |   0    |    Y     |  N   |       |   |
|  4   | zjlxdm |   varchar   | 55 |   0    |    Y     |  N   |       |   |
|  5   | zjhm |   varchar   | 55 |   0    |    Y     |  N   |       |   |
|  6   | jgzjh |   varchar   | 55 |   0    |    Y     |  N   |       |   |
|  7   | dwdm |   varchar   | 55 |   0    |    Y     |  N   |       |   |
|  8   | dwmc |   varchar   | 55 |   0    |    Y     |  N   |       |   |
|  9   | sbbh |   varchar   | 55 |   0    |    Y     |  N   |       |   |
|  10   | cjlx |   varchar   | 55 |   0    |    Y     |  N   |       |   |
|  11   | cjsj |   varchar   | 55 |   0    |    Y     |  N   |       |   |
|  12   | cjsjDt |   timestamp   | 19 |   0    |    Y     |  N   |       |   |
|  13   | cjsjInt |   bigint   | 19 |   0    |    Y     |  N   |       |   |
|  14   | dd |   varchar   | 55 |   0    |    Y     |  N   |       |   |
|  15   | x |   double   | 15 |   12    |    Y     |  N   |       |   |
|  16   | y |   double   | 15 |   12    |    Y     |  N   |       |   |
|  17   | ddgdJd |   double   | 15 |   12    |    Y     |  N   |       |   |
|  18   | ddgdWd |   double   | 15 |   12    |    Y     |  N   |       |   |
|  19   | ddgdGeohash |   varchar   | 55 |   0    |    Y     |  N   |       |   |
|  20   | ddgdGeohash4 |   varchar   | 55 |   0    |    Y     |  N   |       |   |
|  21   | ddgdGeohash5 |   varchar   | 55 |   0    |    Y     |  N   |       |   |
|  22   | ddgdGeohash6 |   varchar   | 55 |   0    |    Y     |  N   |       |   |
|  23   | ddgdGeohash7 |   varchar   | 55 |   0    |    Y     |  N   |       |   |
|  24   | dataGate |   varchar   | 55 |   0    |    Y     |  N   |       |   |
|  25   | sjly |   varchar   | 55 |   0    |    Y     |  N   |       |   |
|  26   | dwdRksj |   varchar   | 55 |   0    |    Y     |  N   |       |   |
|  27   | yxzt |   varchar   | 55 |   0    |    Y     |  N   |       |   |
|  28   | dt |   varchar   | 55 |   0    |    Y     |  N   |       |   |
|  29   | fx |   double   | 25 |   10    |    Y     |  N   |       |   |
|  30   | sd |   double   | 25 |   10    |    Y     |  N   |       |   |
|  31   | sjhm |   varchar   | 55 |   0    |    Y     |  N   |       |   |
|  32   | qwfldm |   varchar   | 55 |   0    |    Y     |  N   |       |   |
|  33   | qwflmc |   varchar   | 55 |   0    |    Y     |  N   |       |   |
|  34   | qwztdm |   varchar   | 55 |   0    |    Y     |  N   |       |   |
|  35   | qwztmc |   varchar   | 55 |   0    |    Y     |  N   |       |   |
|  36   | qwsxdm |   varchar   | 55 |   0    |    Y     |  N   |       |   |
|  37   | qwsxmc |   varchar   | 55 |   0    |    Y     |  N   |       |   |
|  38   | usepre |   varchar   | 55 |   0    |    Y     |  N   |       |   |
|  39   | gpsstrength |   varchar   | 55 |   0    |    Y     |  N   |       |   |

**表名：** <a id="LeaderDutyTable">LeaderDutyTable</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :--: | :--- | :------: | :----: | :----: | :------: | :--: | :----: | :--: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       |   |
|  2   | role |   varchar   | 255 |   0    |    N     |  N   |       | 角色  |
|  3   | name |   varchar   | 255 |   0    |    N     |  N   |       | 姓名  |
|  4   | round |   bit   | 1 |   0    |    Y     |  N   |       | 周期  |

**表名：** <a id="PoliceDetail">PoliceDetail</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :--: | :--- | :------: | :----: | :----: | :------: | :--: | :----: | :--: |
|  1   | id |   intunsigned   | 10 |   0    |    N     |  Y   |       |   |
|  2   | pdepartment |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  3   | department |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  4   | name |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  5   | identify |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  6   | police_code |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  7   | phone |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  8   | type |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  9   | photo |   varchar   | 255 |   0    |    Y     |  N   |       |   |

**表名：** <a id="PoliceLocation">PoliceLocation</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :--: | :--- | :------: | :----: | :----: | :------: | :--: | :----: | :--: |
|  1   | police_code |   varchar   | 80 |   0    |    N     |  Y   |       |   |
|  2   | name |   varchar   | 80 |   0    |    Y     |  N   |       |   |
|  3   | jd |   double   | 15 |   12    |    Y     |  N   |       |   |
|  4   | wd |   double   | 15 |   13    |    Y     |  N   |       |   |
|  5   | time |   varchar   | 20 |   0    |    Y     |  N   |       |   |
|  6   | dwmc |   varchar   | 80 |   0    |    Y     |  N   |       |   |

**表名：** <a id="Sjd">Sjd</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :--: | :--- | :------: | :----: | :----: | :------: | :--: | :----: | :--: |
|  1   | sjdbh |   varchar   | 64 |   0    |    N     |  Y   |       |   |
|  2   | bjr |   varchar   | 50 |   0    |    Y     |  N   |       |   |
|  3   | bjhm |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  4   | scbjsj |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  5   | sjxq |   varchar   | 2000 |   0    |    Y     |  N   |       |   |
|  6   | sfdz |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  7   | jd |   double   | 15 |   12    |    Y     |  N   |       |   |
|  8   | wd |   double   | 15 |   13    |    Y     |  N   |       |   |
|  9   | cjdw |   varchar   | 50 |   0    |    Y     |  N   |       |   |
|  10   | aymc |   varchar   | 20 |   0    |    Y     |  N   |       |   |
|  11   | sjzt |   varchar   | 10 |   0    |    Y     |  N   |       |   |
|  12   | sjztmc |   varchar   | 50 |   0    |    Y     |  N   |       |   |
|  13   | dt |   varchar   | 20 |   0    |    Y     |  N   |       |   |

**表名：** <a id="SjdLocation">SjdLocation</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :--: | :--- | :------: | :----: | :----: | :------: | :--: | :----: | :--: |
|  1   | id |   varchar   | 255 |   0    |    N     |  Y   |       |   |
|  2   | time |   datetime   | 19 |   0    |    N     |  N   |       |   |
|  3   | area_name |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  4   | x |   int   | 10 |   0    |    Y     |  N   |       |   |
|  5   | y |   int   | 10 |   0    |    Y     |  N   |       |   |

**表名：** <a id="SuspectTask">SuspectTask</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :--: | :--- | :------: | :----: | :----: | :------: | :--: | :----: | :--: |
|  1   | task_id |   varchar   | 32 |   0    |    N     |  Y   |       |   |
|  2   | type |   int   | 10 |   0    |    N     |  N   |       |   |
|  3   | time |   timestamp   | 19 |   0    |    N     |  N   |   CURRENT_TIMESTAMP    |   |

**表名：** <a id="clazz">clazz</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :--: | :--- | :------: | :----: | :----: | :------: | :--: | :----: | :--: |
|  1   | id |   varchar   | 255 |   0    |    N     |  Y   |       |   |
|  2   | discription |   varchar   | 255 |   0    |    Y     |  N   |       |   |

**表名：** <a id="duty_table">duty_table</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :--: | :--- | :------: | :----: | :----: | :------: | :--: | :----: | :--: |
|  1   | id |   intunsigned   | 10 |   0    |    N     |  Y   |       |   |
|  2   | department |   varchar   | 255 |   0    |    N     |  N   |       | 单位名称  |
|  3   | duty |   varchar   | 255 |   0    |    N     |  N   |       | 值班人员姓名  |
|  4   | round |   int   | 10 |   0    |    N     |  N   |       | 值班周期  |
|  5   | period |   int   | 10 |   0    |    N     |  N   |       | 周期天数  |
|  6   | phone |   varchar   | 255 |   0    |    Y     |  N   |       |   |

**表名：** <a id="hibernate_sequence">hibernate_sequence</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :--: | :--- | :------: | :----: | :----: | :------: | :--: | :----: | :--: |
|  1   | next_val |   bigint   | 19 |   0    |    Y     |  N   |       |   |

**表名：** <a id="hibernate_sequences">hibernate_sequences</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :--: | :--- | :------: | :----: | :----: | :------: | :--: | :----: | :--: |
|  1   | sequence_name |   varchar   | 255 |   0    |    N     |  Y   |       |   |
|  2   | next_val |   bigint   | 19 |   0    |    Y     |  N   |       |   |

**表名：** <a id="jpa_test">jpa_test</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :--: | :--- | :------: | :----: | :----: | :------: | :--: | :----: | :--: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       |   |
|  2   | jp_name |   varchar   | 64 |   0    |    N     |  N   |       |   |
|  3   | modify_time |   datetime   | 26 |   0    |    N     |  N   |       |   |

**表名：** <a id="phone">phone</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :--: | :--- | :------: | :----: | :----: | :------: | :--: | :----: | :--: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       |   |
|  2   | phone_num |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  3   | student_id |   int   | 10 |   0    |    Y     |  N   |       |   |

**表名：** <a id="student">student</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :--: | :--- | :------: | :----: | :----: | :------: | :--: | :----: | :--: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       |   |

**表名：** <a id="student_entity">student_entity</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :--: | :--- | :------: | :----: | :----: | :------: | :--: | :----: | :--: |
|  1   | name |   varchar   | 255 |   0    |    N     |  Y   |       |   |
|  2   | id |   int   | 10 |   0    |    N     |  Y   |       |   |

**表名：** <a id="studententity">studententity</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :--: | :--- | :------: | :----: | :----: | :------: | :--: | :----: | :--: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       |   |
|  2   | local_date |   date   | 10 |   0    |    Y     |  N   |       |   |
|  3   | local_time |   time   | 8 |   0    |    Y     |  N   |       |   |
|  4   | modify_time |   datetime   | 26 |   0    |    Y     |  N   |       |   |
|  5   | first |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  6   | last |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  7   | middle |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  8   | notes |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  9   | starred |   bit   | 1 |   0    |    N     |  N   |       |   |
|  10   | website |   varchar   | 255 |   0    |    Y     |  N   |       |   |

**表名：** <a id="test">test</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :--: | :--- | :------: | :----: | :----: | :------: | :--: | :----: | :--: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       |   |
|  2   | name |   varchar   | 255 |   0    |    N     |  N   |   abc    |   |

**表名：** <a id="weather_entity">weather_entity</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :--: | :--- | :------: | :----: | :----: | :------: | :--: | :----: | :--: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       |   |
|  2   | air_quality |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  3   | humidity |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  4   | local_date |   date   | 10 |   0    |    Y     |  N   |       |   |
|  5   | org_code |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  6   | org_name |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  7   | pm |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  8   | sunrise |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  9   | sunset |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  10   | temperature_now |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  11   | temperature_range |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  12   | ultraviolet_light |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  13   | weather_term |   varchar   | 255 |   0    |    Y     |  N   |       |   |
|  14   | wind_direction |   varchar   | 255 |   0    |    Y     |  N   |       |   |
