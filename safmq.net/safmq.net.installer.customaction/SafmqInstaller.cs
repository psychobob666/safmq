using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Configuration.Install;
using System.ServiceProcess;


namespace safmq.net.installer.customaction
{
	[RunInstallerAttribute(true)]
	public partial class SafmqInstaller : Installer
	{
		public SafmqInstaller()
		{
			InitializeComponent();

			ServiceInstaller ins = new ServiceInstaller();
			ServiceProcessInstaller spi = new ServiceProcessInstaller();

			ins.StartType = ServiceStartMode.Automatic;
			ins.ServiceName = "safmq";
			ins.Description = "SAFMQ Message Queue Server";
			spi.Account = ServiceAccount.LocalSystem;


			Installers.Add(ins);
			Installers.Add(spi);
		}

	}


	//[RunInstallerAttribute(true)]
	//public class MyProjectInstaller : Installer
	//{
	//    private ServiceInstaller serviceInstaller1;
	//    private ServiceInstaller serviceInstaller2;
	//    private ServiceProcessInstaller processInstaller;

	//    public MyProjectInstaller()
	//    {
	//        // Instantiate installers for process and services.
	//        processInstaller = new ServiceProcessInstaller();
	//        serviceInstaller1 = new ServiceInstaller();
	//        serviceInstaller2 = new ServiceInstaller();

	//        // The services run under the system account.
	//        processInstaller.Account = ServiceAccount.LocalSystem;

	//        // The services are started manually.
	//        serviceInstaller1.StartType = ServiceStartMode.Manual;
	//        serviceInstaller2.StartType = ServiceStartMode.Manual;

	//        // ServiceName must equal those on ServiceBase derived classes.            
	//        serviceInstaller1.ServiceName = "Hello-World Service 1";
	//        serviceInstaller2.ServiceName = "Hello-World Service 2";

	//        // Add installers to collection. Order is not important.
	//        Installers.Add(serviceInstaller1);
	//        Installers.Add(serviceInstaller2);
	//        Installers.Add(processInstaller);
	//    }
	//}


}



