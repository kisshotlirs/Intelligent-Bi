# 智能BI项目


   智能BI，接入Open AI的数据可视化分析工具，通过智能的数据分析和可视化能力帮助构建数据分析系统

## 能力/需求

- 智能分析：用户输入目标和原始数据（图表类型），可以自动生成图表和分析结论
- 图标管理
- 图标生成的异步化（消息队列）
- 对接 AI 能力

## 技术栈
### 后端
- Spring Boot
- MySQL数据库
- MyBatis Plus
- 消息队列（RabbitMQ）
- AI能力（Open AI接口开发）
- Easy Excel（Excel的上传和数据的解析）
- Swagger + Knife4j 接口文档
- Hutool 工具库

### 前端
- React
- Umi + Ant Design Pro
- 可视化开发库（Echarts + HighCharts + AntV）
- umi openapi 代码生成（自动生成后端调用代码）

## 业务流程
1. 用户输入
    - 分析目标
    - 上传原始数据（Excel）
    - 精细化控制图表（比如 图表类型、名称等）
2. 后端校验
    - 校验用户的输入是否合法
    - 成本控制（次数统计和校验、鉴权等）
3. 把处理好的数据传给 AI 模型（调用 AI 接口），
    AI模型提供图表信息、结论文本
4. 图表数据、结论文本在前端进行展示

## AI 提词技巧
1. 持续输入、持续优化
2. 数据压缩，使用 csv 对 Excel 文件的数据进行提取压缩