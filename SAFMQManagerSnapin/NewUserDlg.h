/*
 Copyright 2005 Matthew J. Battey

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software distributed
	under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
	CONDITIONS OF ANY KIND, either express or implied. See the License for the
	specific language governing permissions and limitations under the License.




This software implements a platform independent Store and Forward Message Queue.
*/
// NewServerDlg.h: interface for the CNewUserDlg class.
//
//////////////////////////////////////////////////////////////////////

#if !defined(_NEW_USER_DLG)
#define _NEW_USER_DLG

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

#include "resource.h"

class CNewUserDlg : public CDialogImpl<CNewUserDlg>  
{
public:
	enum { IDD = IDD_NEW_USER };

private:
	std::string	password;
	std::string username;
	std::string description;

public:
	CNewUserDlg();
	virtual ~CNewUserDlg();


	LRESULT OnInitDialog(UINT uMsg, WPARAM wParam, LPARAM lParam, BOOL& bHandled);

	LRESULT OnOK(WORD wNotifyCode, WORD wID, HWND hWndCtl, BOOL& bHandled);
	LRESULT OnCancel(WORD wNotifyCode, WORD wID, HWND hWndCtl, BOOL& bHandled);

	const std::string& getPassword() { return password; }
	const std::string& getUsername() { return username; }
	const std::string& getDescription() { return description; }


	BEGIN_MSG_MAP(CNewUserDlg)
		MESSAGE_HANDLER(WM_INITDIALOG, OnInitDialog)
		COMMAND_ID_HANDLER(IDOK, OnOK)
		COMMAND_ID_HANDLER(IDCANCEL, OnCancel)
	END_MSG_MAP()
};

#endif // !defined(_NEW_USER_DLG)
