import logo from './images/logo.png';
import './App.css';
import React from 'react';
import {getAllStudents} from './client';
import {deleteStudent} from './client';
import {useState, useEffect} from 'react';
import StudentDrawerForm from './StudentDrawerForm';
import { QuestionCircleOutlined } from '@ant-design/icons';
import { Popconfirm } from 'antd';
import {errorNotification, successNotification} from "./Notification";
import { Layout, Menu, Breadcrumb, Table, Spin, Empty, Button, Badge,Tag,
Avatar,Radio, Image} from 'antd';
import {
    DesktopOutlined,
    PieChartOutlined,
    FileOutlined,
    TeamOutlined,
    UserOutlined,
    LoadingOutlined,
    PlusOutlined
} from '@ant-design/icons';

const { Header, Content, Footer, Sider } = Layout;
const { SubMenu } = Menu; 
const TheAvatar = ({name}) => {
	let trim = name.trim();
	let idx = name.indexOf(' ');
	if(trim.length === 0) {
		return <Avatar icon={<UserOutlined/>}/>
	}
	const split = trim.split(" ");
	if (split.length === 1) {
		return <Avatar>{name.charAt(0)}</Avatar>
	}
	return <Avatar> 
		{`${name.charAt(0)}${name.charAt(idx+1)}`} 
	</Avatar>
};

const removeStudent = (studentId, callback) => {
    deleteStudent(studentId).then(() => {
        successNotification( "Student deleted", `Student with ${studentId} was deleted`);
        callback();
    }).catch(err=>
    	err.response.json.then(res=> {
			errorNotification(
				"There is an issue",
				`${res.message} [${res.status}] [${res.error}]`
			);
		}
    	)
		
	);
}

const columns = fetchStudents => [
  {
    title: '',
    dataIndex: 'avatar',
    key: 'avatar',
    render: (text, student) => 
    	 <TheAvatar name={student.name}/> 
  },
  {
    title: 'Id',
    dataIndex: 'id',
    key: 'id',
  },
  {
    title: 'Name',
    dataIndex: 'name',
    key: 'name',
  },
  {
    title: 'Email',
    dataIndex: 'email',
    key: 'email',
  },
  {
    title: 'Gender',
    dataIndex: 'gender',
    key: 'gender',
  },
    {
        title: 'Actions',
        key: 'actions',
        render: (text, student) =>
            <Radio.Group>
                <Popconfirm
                    placement='topRight'
                    title={`Are you sure to delete ${student.name}`}
                    onConfirm={() => removeStudent(student.id, fetchStudents)}
                    okText='Yes'
                    cancelText='No'>
                    <Radio.Button value="small">Delete</Radio.Button>
                </Popconfirm>
                <Radio.Button value="small">Edit</Radio.Button>
            </Radio.Group>
    }
];
const antIcon = (
  <LoadingOutlined
    style={{
      fontSize: 24,
    }}
    spin
  />
);


function App() {
	const [students, setStudents] = useState ([]);
	const [collapsed, setCollapsed] = useState(false);
	const [fetching, setFetching] = useState(false);
	const [showDrawer, setShowDrawer] = useState(false);
	const [studentCount, setStudentCount] = useState(1);
	const fetchStudents = () => 
		getAllStudents()
		.then(res => res.json())
		.then(data => {
			console.log(students);
			setStudents(data);
		}).catch(err =>{
			console.log(err.response);
			err.response.json().then(data=> {
			console.log(data);
			errorNotification(
				"There was an issue", 
				`${data.message} [status code:${data.status}] [path:${data.path}] [error:${data.error}]`
			);
			});
		}).finally(() => setFetching(false));
		
	useEffect(() => {
		fetchStudents();
	},[]
		
	);
		
	const renderStudents = () => {
		if(fetching){
			return <Spin indicator={antIcon} />
		}
		if(students.length <= 0){
			return <>
			<Empty /> 
			<Button onClick={() => setShowDrawer(!showDrawer)}
			type="primary" shape="round" icon={<PlusOutlined />} size="32px">
				Add new Student
			</Button>
			<StudentDrawerForm
          		showDrawer={showDrawer}
            	setShowDrawer={setShowDrawer}
            	fetchStudents={fetchStudents}
          	/>
			</>
		}
		return <>
			<StudentDrawerForm
          		showDrawer={showDrawer}
            	setShowDrawer={setShowDrawer}
            	fetchStudents={fetchStudents}
          	/>
			<Table 
			dataSource={students} 
			columns={columns(fetchStudents)}
			bordered           
			title = {()=> 
					<>
			        	<small className = "stNo" > Number of students </small>
						<Badge count={students.length} className="site-badge-count-4"/>
			     		<br/><br/>
			     		<Button 
			     			value="small"
							onClick={() => setShowDrawer(!showDrawer)}
							type="primary" shape="round" icon={<PlusOutlined />} size="32px">
				             Add New Student  
			        	</Button>
			     	</>
			     }
			     pagination ={{pageSize:50}} 
				 scroll={{y:500}} rowKey = {(student) => student.id}
			/>
		</>
	}
	
  return <Layout style={{ minHeight: '100vh' }}>
        <Sider collapsible collapsed={collapsed}
               onCollapse={setCollapsed}>
            <div className="logo" />
            <Menu theme="dark" defaultSelectedKeys={['1']} mode="inline">
                <Menu.Item key="1" icon={<PieChartOutlined />}>
                    Option 1
                </Menu.Item>
                <Menu.Item key="2" icon={<DesktopOutlined />}>
                    Option 2
                </Menu.Item>
                <SubMenu key="sub1" icon={<UserOutlined />} title="Student">
                    <Menu.Item key="3">Tom</Menu.Item>
                    <Menu.Item key="4">List</Menu.Item>
                    <Menu.Item key="5">Alex</Menu.Item>
                </SubMenu>
                <SubMenu key="sub2" icon={<TeamOutlined />} title="Team">
                    <Menu.Item key="6">Team 1</Menu.Item>
                    <Menu.Item key="8">Team 2</Menu.Item>
                </SubMenu>
                <Menu.Item key="9" icon={<FileOutlined />}>
                    Files
                </Menu.Item>
            </Menu>
        </Sider>
        <Layout className="site-layout">
            <Header className="site-layout-background" style={{ padding: 0 }} />
            <Content style={{ margin: '0 16px' }}>
                <Breadcrumb style={{ margin: '16px 0' }}>
                    <Breadcrumb.Item>Student</Breadcrumb.Item>
                    <Breadcrumb.Item>List</Breadcrumb.Item>
                </Breadcrumb>
                <div className="site-layout-background" style={{ padding: 24, minHeight: 360 }}>
                    {renderStudents()}
                </div>
            </Content>
            <Footer style={{ textAlign: 'center' }}>
            <Image 
            width={35}
            src={logo}
            />
            <br/>
            By Cadence IT
            </Footer>
        </Layout>
    </Layout>
}

export default App;
